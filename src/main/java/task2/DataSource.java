package task2;

import java.sql.Connection;

public class DataSource {

    static ConnectionPool pool = new ConnectionPool();

    private DataSource(){
    }

    public static Connection getConnection() {

        Connection connection;
        do {
            connection = pool.getConnectionFromPool();
        }while (connection == null);
        return connection;
    }

    public static void returnConnection(Connection connection) {
        pool.returnConnectionToPool(connection);
    }
}
