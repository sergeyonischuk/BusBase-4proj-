package study.ua.services;

import study.ua.DAO.*;
import study.ua.connection.DaoFactory;
import study.ua.entityes.Application;
import study.ua.entityes.Bus;
import study.ua.entityes.Driver;
import study.ua.entityes.Route;
import study.ua.enums.Condition;

import java.util.ArrayList;
import java.util.List;
public class CommonService {
    private DaoFactory daoFactory = new DaoFactory();

    public List<Driver> getWorkingRollingStock() {
        BusDAO busDAO = daoFactory.getBusDAO();
        DriverDAO driverDAO = daoFactory.getDriverDAO();
        BusDriverDAO busDriverDAO = daoFactory.getBusDriverDAO();

        List<Bus> buses = busDAO.getAll();
        List<Driver> drivers = new ArrayList<>();

        for (Bus bus : buses) {
            String busNumber = bus.getNumber();
            Bus currentBus = busDAO.getByID(busNumber);

                if (currentBus.getCondition() != Condition.REPAIR_NEEDED) {
                String passport = busDriverDAO.getDriverIdByBusNumber(busNumber);
                Driver driver = driverDAO.getByPasport(passport);
                driver.setBus(currentBus);
                drivers.add(driver);
            }
        }
        return drivers;
    }

    public int getAppIDbyDriverID(String id) {
        ConfirmedAppDAO confirmedAppDAO = new DaoFactory().getConfirmedAppDAO();
        return confirmedAppDAO.getApplicationIDByDriverID(id);
    }

    public List<Bus> getBusesFromDrivers(List<Driver> drivers) {
        List<Bus> buses = new ArrayList<>();
        for (Driver driver : drivers) {
            buses.add(driver.getBus());
        }
        return buses;
    }

    public Application getAppByID(int id) {
        ApplicationDAO applicationDAO = daoFactory.getApplicationDAO();
        return applicationDAO.getByID(id);
    }

    public Route getRouteByID(int id) {
        RouteDAO routeDAO = daoFactory.getRouteDAO();
        return routeDAO.getByID(id);
    }
}
