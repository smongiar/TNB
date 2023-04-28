package software.tnb.db.common.local;

import software.tnb.db.common.service.SQL;

import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.WaitStrategy;

public class DBContainer extends GenericContainer<DBContainer> {
    private final int port;

    public DBContainer(SQL service, int port, WaitStrategy waitStrategy) {
        super(service.image());
        this.port = port;
        withExposedPorts(port);
        withEnv(service.containerEnvironment());
        waitingFor(waitStrategy);
    }

    public DBContainer(SQL service, int port, WaitStrategy waitStrategy, String sharedFolderPath) {
        this(service, port, waitStrategy);
        withFileSystemBind(sharedFolderPath, "/tmp/custom/", BindMode.READ_WRITE);
    }

    public int getPort() {
        return getMappedPort(port);
    }
}
