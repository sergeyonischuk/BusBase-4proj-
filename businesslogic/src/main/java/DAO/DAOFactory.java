package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {
    Connection connection;

    public DAOFactory() {
        InputStream in = DAOFactory.class.getResourceAsStream("/db.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
            Class.forName(properties.getProperty("db.driver"));
            connection = DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.username"), properties.getProperty("db.password"));
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public ApplicationDAO getApplicationDAO() {
        return new ApplicationDAO();
    }

    public BusDAO getBusDAO() {
        return new BusDAO();
    }

    public BusDriverDAO getBusDriverDAO() {
        return new BusDriverDAO();
    }

    public CityDAO getCityDAO() {
        return new CityDAO();
    }

    public ConfirmedAppDAO getConfirmedAppDAO() {
        return new ConfirmedAppDAO();
    }

    public DriverDAO getDriverDAO() {
        return new DriverDAO();
    }

    public RouteDAO getRouteDAO() {
        return new RouteDAO();
    }

    UserDAO getUserDAO() {
        return new UserDAO();
    }
}
