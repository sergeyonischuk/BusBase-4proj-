package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilConn {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/busbase";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "63gabaja1";

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("connection ok");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("connection not ok");
        }
        return connection;
    }
}
