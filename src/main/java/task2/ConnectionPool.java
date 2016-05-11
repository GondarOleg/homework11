package task2;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConnectionPool {

    static final int MAX_POOL_SIZE = Configuration.getInstance().DB_MAX_CONNECTIONS;

    private static final Logger logger = Logger.getLogger(String.valueOf(ConnectionPool.class));

    List<Connection> availableConnections = new ArrayList<>();

    public ConnectionPool()
    {
        initializeConnectionPool();
    }

    private void initializeConnectionPool()
    {
        while(!checkIfConnectionPoolIsFull())
        {
            availableConnections.add(createNewConnectionForPool());
        }
    }

    private synchronized boolean checkIfConnectionPoolIsFull()
    {

        if(availableConnections.size() < MAX_POOL_SIZE)
        {
            return false;
        }

        return true;
    }

    private Connection createNewConnectionForPool()
    {
        Configuration config = Configuration.getInstance();
        try {
            Class.forName(config.DB_DRIVER);
            return DriverManager.getConnection(
                    config.DB_URL, config.DB_USER_NAME, config.DB_PASSWORD);


        } catch (ClassNotFoundException | SQLException e) {
            org.apache.log4j.BasicConfigurator.configure();
            logger.error(e);
        }
        return null;

    }

    public synchronized Connection getConnectionFromPool()
    {
        Connection connection = null;
        if(!availableConnections.isEmpty())
        {
            connection = availableConnections.get(0);
            availableConnections.remove(0);
        }
        return connection;
    }

    public synchronized void returnConnectionToPool(Connection connection)
    {
        availableConnections.add(connection);
    }
}