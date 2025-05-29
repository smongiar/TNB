package software.tnb.kafka.resource.openshift;

import software.tnb.common.config.TestConfiguration;
import software.tnb.common.deployment.ReusableOpenshiftDeployable;
import software.tnb.common.deployment.WithName;
import software.tnb.common.deployment.WithOperatorHub;
import software.tnb.common.openshift.OpenshiftClient;
import software.tnb.common.utils.WaitUtils;
import software.tnb.kafka.service.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.auto.service.AutoService;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import cz.xtf.core.openshift.OpenShiftWaiters;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.api.model.ServiceAccountBuilder;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.strimzi.api.kafka.KafkaList;
import io.strimzi.api.kafka.KafkaNodePoolList;
import io.strimzi.api.kafka.KafkaTopicList;
import io.strimzi.api.kafka.KafkaUserList;
import io.strimzi.api.kafka.model.AclOperation;
import io.strimzi.api.kafka.model.AclResourcePatternType;
import io.strimzi.api.kafka.model.AclRule;
import io.strimzi.api.kafka.model.AclRuleResource;
import io.strimzi.api.kafka.model.AclRuleTopicResourceBuilder;
import io.strimzi.api.kafka.model.AclRuleType;
import io.strimzi.api.kafka.model.ContainerEnvVar;
import io.strimzi.api.kafka.model.KafkaBuilder;
import io.strimzi.api.kafka.model.KafkaTopic;
import io.strimzi.api.kafka.model.KafkaTopicBuilder;
import io.strimzi.api.kafka.model.KafkaUser;
import io.strimzi.api.kafka.model.KafkaUserBuilder;
import io.strimzi.api.kafka.model.listener.KafkaListenerAuthenticationCustom;
import io.strimzi.api.kafka.model.listener.KafkaListenerAuthenticationCustomBuilder;
import io.strimzi.api.kafka.model.listener.arraylistener.KafkaListenerType;
import io.strimzi.api.kafka.model.nodepool.KafkaNodePool;
import io.strimzi.api.kafka.model.nodepool.KafkaNodePoolBuilder;
import io.strimzi.api.kafka.model.nodepool.ProcessRoles;
import io.strimzi.api.kafka.model.status.Condition;

@AutoService(Kafka.class)
public class OpenshiftKafka extends Kafka implements ReusableOpenshiftDeployable, WithName, WithOperatorHub {
    private static final Logger LOG = LoggerFactory.getLogger(OpenshiftKafka.class);

    private static MixedOperation<io.strimzi.api.kafka.model.Kafka, KafkaList, Resource<io.strimzi.api.kafka.model.Kafka>> kafkaCrdClient;
    private static MixedOperation<io.strimzi.api.kafka.model.nodepool.KafkaNodePool, KafkaNodePoolList,
        Resource<io.strimzi.api.kafka.model.nodepool.KafkaNodePool>> kafkaCrdNodePoolClient;
    private static MixedOperation<io.strimzi.api.kafka.model.KafkaUser, KafkaUserList,
        Resource<io.strimzi.api.kafka.model.KafkaUser>> kafkaCrdUserClient;

    @Override
    public void deploy() {
        kafkaCrdClient =
            OpenshiftClient.get().resources(io.strimzi.api.kafka.model.Kafka.class, KafkaList.class);
        kafkaCrdNodePoolClient =
            OpenshiftClient.get().resources(io.strimzi.api.kafka.model.nodepool.KafkaNodePool.class, KafkaNodePoolList.class);
        kafkaCrdUserClient =
            OpenshiftClient.get().resources(io.strimzi.api.kafka.model.KafkaUser.class, KafkaUserList.class);
        ReusableOpenshiftDeployable.super.deploy();
    }

    @Override
    public long waitTime() {
        return 600_000;
    }

    @Override
    public Predicate<Pod> podSelector() {
        return p -> OpenshiftClient.get().hasLabels(p, Map.of("strimzi.io/name", name() + "-kafka"));
    }

    @Override
    public void undeploy() {
        // https://github.com/strimzi/strimzi-kafka-operator/issues/5042
        if (!usePreparedGlobalInstallation()) {
            if (!TestConfiguration.skipTearDownOpenshiftAMQStreams()) {
                deleteTopics();
                deleteNodePools();
                deleteUsers();
                kafkaCrdClient.withName(name()).withPropagationPolicy(DeletionPropagation.BACKGROUND).delete();
                kafkaCrdNodePoolClient.withName(name()).withPropagationPolicy(DeletionPropagation.BACKGROUND).delete();
                kafkaCrdUserClient.withName(name() + "-sa").withPropagationPolicy(DeletionPropagation.BACKGROUND).delete();
                OpenShiftWaiters.get(OpenshiftClient.get(), () -> false).areNoPodsPresent("strimzi.io/cluster", name())
                    .timeout(120_000).waitFor();
                deleteSubscription(() -> OpenshiftClient.get().getLabeledPods("strimzi.io/kind", "cluster-operator").isEmpty());
            }
        }
    }

    @Override
    public void openResources() {
        //createBasicUser();
        createUser(name());
        extractCertificate();
        connectionProperties();
        super.openResources();
    }

    @Override
    public void create() {
        if (!usePreparedGlobalInstallation()) { // could be: if (prepareGlobalKafka || !usePreparedGlobalInstallation)
            createSubscription();
            deployKafkaCR();
        }
    }

    /**
     * https://strimzi.io/blog/2023/01/25/running-apache-kafka-on-fips-enabled-kubernetes-cluster/
     * until Strimzi 0.33 will be used
     *
     * @return
     */
    @Override
    public List<EnvVar> getOperatorEnvVariables() {
        return List.of(new EnvVar("FIPS_MODE", "disabled", null));
    }

    @Override
    public boolean isReady() {
        try {
            return kafkaCrdClient
                .inNamespace(targetNamespace())
                .withName(name())
                .get()
                .getStatus().getConditions()
                .stream()
                .filter(c -> "Ready".equals(c.getType()))
                .map(Condition::getStatus)
                .map(Boolean::parseBoolean)
                .findFirst().orElse(false);
        } catch (Exception ignored) {
            return false;
        }
    }

    @Override
    public boolean isDeployed() {
        return OpenshiftClient.get().inNamespace(targetNamespace(), c -> !c.getLabeledPods("name", "amq-streams-cluster-operator").isEmpty()
            && kafkaCrdClient.inNamespace(targetNamespace()).withName(name()).get() != null);
    }

    @Override
    public String name() {
        return "my-kafka-cluster";
    }

    private void deployKafkaCR() {
        ContainerEnvVar trustoreLocation = new ContainerEnvVar();
        ContainerEnvVar trustoreType = new ContainerEnvVar();
        trustoreLocation.setName("OAUTH_SSL_TRUSTSTORE_LOCATION");
        trustoreLocation.setValue("/var/run/secrets/kubernetes.io/serviceaccount/ca.crt");
        trustoreType.setName("OAUTH_SSL_TRUSTSTORE_TYPE");
        trustoreType.setValue("PEM");

        KafkaListenerAuthenticationCustom auth = new KafkaListenerAuthenticationCustomBuilder()
            .addToListenerConfig(Map.of(
                "type", "oauth",
                "validIssuerUri", "https://kubernetes.default.svc",
                "jwksEndpointUri", "https://kubernetes.default.svc.cluster.local/openid/v1/jwks",
                "serverBearerTokenLocation", "/var/run/secrets/kubernetes.io/serviceaccount/token",
                "checkAccessTokenType", "false",
                "includeAcceptHeader", "false",
                "userNameClaim", "['kubernetes.io'].['serviceaccount'].['name']",
                "maxSecondsWithoutReauthentication", "3600",
                "customClaimCheck", "@.['kubernetes.io'] && @.['kubernetes.io'].['namespace'] in ['kafka-oauth-ocp']"
            ))
            .build();
        //@formatter:off
        io.strimzi.api.kafka.model.Kafka kafka = new KafkaBuilder()
            .withNewMetadata()
                .withName(name())
            .withAnnotations(Map.of(
                "strimzi.io/kraft", "enabled",
                "strimzi.io/node-pools", "enabled"
            ))
            .endMetadata()
            .withNewSpec()
                .withNewKafka()
                    .withReplicas(1)
                    .addNewListener()
                        .withName("plain")
                        .withPort(9092)
                        .withTls(false)
                        .withType(KafkaListenerType.INTERNAL)
                    .endListener()
                    .addNewListener()
                        .withName("route")
                        .withPort(9093)
                        .withTls(true)
                        .withType(KafkaListenerType.ROUTE)
                        .withNewKafkaListenerAuthenticationCustomAuthLike(auth)
                        .endKafkaListenerAuthenticationCustomAuth()
                    .endListener()
                    .withNewEphemeralStorage()
                    .endEphemeralStorage()
                    .withNewInlineLogging()
                    .withLoggers(Map.of(
                        "kafka.root.logger.level", "INFO",
                        "log4j.logger.kafka.request.logger", "INFO",
                        "log4j.logger.io.strimzi.kafka.oauth", "DEBUG",
                        "log4j.logger.kafka.authorizer.logger", "DEBUG"))
                    .endInlineLogging()
                    .withConfig(Map.of(
                        "offsets.topic.replication.factor", "1",
                        "transaction.state.log.replication.factor", "1",
                        "default.replication.factor", "1",
                        "min.insync.replicas", "1",
                        "transaction.state.log.min.isr", "1"))
                    .withNewTemplate()
                        .withNewKafkaContainer()
                            .withEnv(new ContainerEnvVar[]{trustoreLocation, trustoreType})
                        .endKafkaContainer()
                    .endTemplate()
                .endKafka()
                .withNewZookeeper()
                    .withReplicas(1)
                    .withNewEphemeralStorage().endEphemeralStorage()
                .endZookeeper()
                .withNewEntityOperator()
                    .withNewTopicOperator().endTopicOperator()
                    .withNewUserOperator().endUserOperator()
                .endEntityOperator()
                .endSpec()
            .build();
        //@formatter:on

        kafkaCrdClient.inNamespace(targetNamespace()).createOrReplace(kafka);
        createNodePool(name());
    }

    @Override
    public String bootstrapServers() {
        return findBootstrapServers("plain");
    }

    @Override
    public String bootstrapSSLServers() {
        return findBootstrapServers("route");
    }

    private String findBootstrapServers(String listnerType) {
        return kafkaCrdClient.inNamespace(targetNamespace()).withName(name()).get().getStatus().getListeners()
            .stream()
            .filter(l -> listnerType.equals(l.getType()))
            .findFirst().get().getBootstrapServers();
    }

    @Override
    public void createTopic(String name, int partitions, int replicas) {
        //@formatter:off
        KafkaTopic kafkaTopic = new KafkaTopicBuilder()
            .withNewMetadata()
                .withName(name)
                .addToLabels("strimzi.io/cluster", name())
            .endMetadata()
            .withNewSpec()
                .withPartitions(partitions)
                .withReplicas(replicas)
            .endSpec()
            .build();
        //@formatter:on
        OpenshiftClient.get().resources(KafkaTopic.class, KafkaTopicList.class).inNamespace(targetNamespace()).createOrReplace(kafkaTopic);
    }

    @Override
    public void createNodePool(String name, String storageType, String metadataType, int replicas) {
        //@formatter:off
        io.strimzi.api.kafka.model.nodepool.KafkaNodePool nodePool = new KafkaNodePoolBuilder()
            .withNewMetadata()
                .withName(name)
                .addToLabels("strimzi.io/cluster", name())
                .withNamespace(targetNamespace())
            .endMetadata()
            .withNewSpec()
                .withRoles(Arrays.asList(ProcessRoles.values()))
                .withNewEphemeralStorage()
                .endEphemeralStorage()
                .withReplicas(replicas)
            .endSpec()
            .build();
        //@formatter:on
        kafkaCrdNodePoolClient.inNamespace(targetNamespace()).createOrReplace(nodePool);
    }

    @Override
    public void createUser(String name) {
        //setup ServiceAccount
        OpenshiftClient.get().serviceAccounts().inNamespace(targetNamespace()).resource(new ServiceAccountBuilder()
            .withNewMetadata().withName(name() + "-sa").endMetadata()
            .build()).serverSideApply();

        AclRuleResource topicResource = new AclRuleTopicResourceBuilder()
            .withPatternType(AclResourcePatternType.LITERAL)
            .withName("helloWorld").build();
        AclRuleResource groupResource = new AclRuleTopicResourceBuilder()
            .withName("'*'")
            .withPatternType(AclResourcePatternType.LITERAL).build();
        AclRule aclTopic = new AclRule(AclRuleType.ALLOW, topicResource, "'*'",
            List.of(AclOperation.READ, AclOperation.DESCRIBE, AclOperation.WRITE, AclOperation.CREATE));
        AclRule aclGroup = new AclRule(AclRuleType.ALLOW, groupResource, "'*'",
            List.of(AclOperation.READ));
        //@formatter:off
        io.strimzi.api.kafka.model.KafkaUser user = new KafkaUserBuilder()
            .withNewMetadata()
                .withName(name)
                .addToLabels("strimzi.io/cluster", name() + "-sa")
                .withNamespace(targetNamespace())
            .endMetadata()
            .withNewSpec()
                .withNewKafkaUserAuthorizationSimple()
                    .addToAcls(aclTopic)
                    .addToAcls(aclGroup)
                .endKafkaUserAuthorizationSimple()
            .endSpec()
            .build();
        //@formatter:on
        kafkaCrdUserClient.inNamespace(targetNamespace()).createOrReplace(user);
    }

    public void deleteTopics() {
        final NonNamespaceOperation<KafkaTopic, KafkaTopicList, Resource<KafkaTopic>> topics =
            OpenshiftClient.get().resources(KafkaTopic.class, KafkaTopicList.class).inNamespace(targetNamespace());
        topics.list().getItems().forEach(t -> topics.resource(t).delete());
        WaitUtils.waitFor(() -> topics.list().getItems().isEmpty(), "Waiting until all topics are removed");
    }

    public void deleteNodePools() {
        final NonNamespaceOperation<KafkaNodePool, KafkaNodePoolList, Resource<KafkaNodePool>> nodePools =
            kafkaCrdNodePoolClient.inNamespace(targetNamespace());
        nodePools.list().getItems().forEach(t -> nodePools.resource(t).delete());
        WaitUtils.waitFor(() -> nodePools.list().getItems().isEmpty(), "Waiting until all nodePools are removed");
    }

    public void deleteUsers() {
        final NonNamespaceOperation<KafkaUser, KafkaUserList, Resource<KafkaUser>> users =
            kafkaCrdUserClient.inNamespace(targetNamespace());
        users.list().getItems().forEach(t -> users.resource(t).delete());
        WaitUtils.waitFor(() -> users.list().getItems().isEmpty(), "Waiting until all users are removed");
    }

    private void createBasicUser() { // via https://access.redhat.com/documentation/en-us/red_hat_amq/2021
        // .q2/html-single/using_amq_streams_on_openshift/index#type-KafkaClientAuthenticationPlain-reference
        String password = Base64.getEncoder().encodeToString(account().basicPassword().getBytes());
        Map<String, String> labels = new HashMap<>();
        labels.put("strimzi.io/kind", "KafkaUser");
        labels.put("strimzi.io/cluster", name());

        SecretBuilder sb = new SecretBuilder()
            .withApiVersion("v1")
            .editOrNewMetadata().withName(account().basicUser()).withLabels(labels).endMetadata()
            .withType("Opaque")
            .withData(Collections.singletonMap("password", password));
        OpenshiftClient.get().secrets().createOrReplace(sb.build());
    }

    @Override
    public void cleanup() {
        LOG.debug("Cleaning kafka instance");
        deleteTopics();
        deleteNodePools();
        deleteUsers();
    }

    public void extractCertificate() {
        LOG.debug("Extracting kafka certificate");
        String cert = new String(Base64.getDecoder() // created while installation of kafka in target namespace
            .decode(OpenshiftClient.get().inNamespace(targetNamespace(), c -> c.secrets().withName(name() + "-cluster-ca-cert")).get().getData()
                .get("ca.crt")));
        String password = new String(Base64.getDecoder()
            .decode(OpenshiftClient.get().inNamespace(targetNamespace(), c -> c.secrets().withName(name() + "-cluster-ca-cert")).get().getData()
                .get("ca.password")));
        account().setTrustStorePassword(password);
        try {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(null, password.toCharArray());
            final CertificateFactory cf = CertificateFactory.getInstance("X.509");
            try (ByteArrayInputStream is = new ByteArrayInputStream(cert.getBytes())) {
                ks.setCertificateEntry("ca.crt", cf.generateCertificate(is));
            }

            FileOutputStream fos = new FileOutputStream(account().trustStore());
            ks.store(fos, password.toCharArray());
            fos.close();
        } catch (Exception e) {
            throw new RuntimeException("Unable to extract kafka certificate", e);
        }
    }

    private void connectionProperties() {
        props.setProperty("bootstrap.servers", bootstrapSSLServers());
        props.setProperty("security.protocol", "SSL");
        props.setProperty("ssl.truststore.password", account().trustStorePassword());
        props.setProperty("ssl.truststore.location", new File(account().trustStore()).getAbsolutePath());
        props.setProperty("ssl.truststore.type", "PKCS12");
    }

    @Override
    public String operatorName() {
        return "amq-streams";
    }

    private boolean usePreparedGlobalInstallation() {
        return TestConfiguration.useGlobalOpenshiftKafka();
    }

    @Override
    public String targetNamespace() {
        return usePreparedGlobalInstallation() ? "openshift-operators" : OpenshiftClient.get().getNamespace();
    }
}
