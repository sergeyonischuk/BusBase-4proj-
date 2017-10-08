package study.ua.connection;

import lombok.extern.log4j.Log4j;
import study.ua.DAO.*;
@Log4j
public class DaoFactory {
    public ApplicationDAO getApplicationDAO() {
        return new ApplicationDAO();
    }
    public BusDAO getBusDAO() {
        return new BusDAO();
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
    public UserDAO getUserDAO() {
        return new UserDAO();
    }
    public BusDriverDAO getBusDriverDAO() {
        return new BusDriverDAO();
    }
    public DriverUserDAO getDriverUserDAO() {
        return new DriverUserDAO();
    }
}
