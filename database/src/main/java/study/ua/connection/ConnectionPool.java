package study.ua.connection;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.SQLException;

@Log4j
public class ConnectionPool {
    private static ConnectionPool connectionPool;
    private static HikariDataSource dataSource;
    private static final Integer CONNECTION_POOL_SIZE = 10;

    private ConnectionPool() {
    }

    public static ConnectionPool getConnectionPoolInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
            dataSource = new HikariDataSource();
            dataSource.setUsername("root");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/busbase");
            dataSource.setPassword("root");
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setMaximumPoolSize(CONNECTION_POOL_SIZE);
        }
        return connectionPool;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            log.error(e);
        }
        throw new IllegalArgumentException("Cannot get connection");
    }

}
