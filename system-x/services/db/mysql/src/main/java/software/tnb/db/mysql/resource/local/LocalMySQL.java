package software.tnb.db.mysql.resource.local;

import software.tnb.common.deployment.Deployable;
import software.tnb.db.common.local.LocalDB;
import software.tnb.db.mysql.service.MySQL;

import org.testcontainers.containers.wait.strategy.Wait;

import com.google.auto.service.AutoService;

import java.nio.file.Paths;

@AutoService(MySQL.class)
public class LocalMySQL extends MySQL implements Deployable {
    private LocalDB localDb;

    public LocalMySQL() {
        localDb = new LocalDB(this, PORT, Wait.forLogMessage(".*ready for connections.* port: " + PORT + ".*", 1),
            Paths.get(LocalMySQL.class.getResource("/config/my.cnf").toString()).toString());
    }

    @Override
    public String jdbcConnectionUrl() {
        return String.format("jdbc:mysql://localhost:%d/%s?tlsVersions=%s&sslMode=DISABLED", localDb.getPort(), account().database(), "TLSv1.2");
    }

    @Override
    public String hostname() {
        return "localhost";
    }

    @Override
    public int port() {
        return localDb.getPort();
    }

    @Override
    public void deploy() {
        localDb.deploy();
    }

    @Override
    public void undeploy() {
        localDb.undeploy();
    }

    @Override
    public void openResources() {
        localDb.openResources();
    }

    @Override
    public void closeResources() {
        localDb.closeResources();
        validation = null;
    }

    @Override
    public String name() {
        return "MySQL";
    }
}
