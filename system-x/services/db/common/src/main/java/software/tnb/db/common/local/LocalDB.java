package software.tnb.db.common.local;

import software.tnb.common.deployment.Deployable;
import software.tnb.db.common.service.SQL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.wait.strategy.WaitStrategy;
import org.testcontainers.utility.MountableFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class LocalDB implements Deployable {
    private static final Logger LOG = LoggerFactory.getLogger(LocalDB.class);
    private final SQL sqlService;
    private final DBContainer container;

    public LocalDB(SQL sqlService, int port, WaitStrategy waitStrategy) {
        this.sqlService = sqlService;
        this.container = new DBContainer(sqlService, port, waitStrategy);
    }

    public LocalDB(SQL sqlService, int port, WaitStrategy waitStrategy, String sharedFolderPath) {
        this.sqlService = sqlService;
        this.container = new DBContainer(sqlService, port, waitStrategy, sharedFolderPath);

    }

    @Override
    public void deploy() {
        LOG.info("Starting " + sqlService.name() + " container");
        container.start();
        LOG.info(sqlService.name() + " container started");
    }

    @Override
    public void undeploy() {
        container.stop();
    }

    @Override
    public void openResources() {
        // no-op
    }

    @Override
    public void closeResources() {
        // no-op
    }

    public int getPort() {
        return container.getPort();
    }
}
