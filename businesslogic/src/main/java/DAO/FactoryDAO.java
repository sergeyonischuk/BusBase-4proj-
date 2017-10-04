package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FactoryDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/busbase";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    private Connection connection;

    public FactoryDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println(connection.getCatalog());
            System.out.println(connection.getSchema());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ApplicationDAO getApplicationDAO() {
        return new ApplicationDAO(connection);
    }
    public BusDAO getBusDAO() {
        return new BusDAO(connection);
    }
    public CityDAO getCityDAO() {
        return new CityDAO(connection);
    }
    public ConfirmedAppDAO getConfirmedAppDAO() {
        return new ConfirmedAppDAO(connection);
    }
    public DriverDAO getDriverDAO() {
        return new DriverDAO(connection);
    }
    public RouteDAO getRouteDAO() {
        return new RouteDAO(connection);
    }
    public UserDAO getUserDAO() {
        return new UserDAO(connection);
    }
    public BusDriverDAO getBusDriverDAO() {
        return new BusDriverDAO(connection);
    }
}
