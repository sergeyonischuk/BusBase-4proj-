package study.ua.services;

import lombok.extern.log4j.Log4j;
import study.ua.DAO.*;
import study.ua.connection.DaoFactory;
import study.ua.entityes.Bus;
import study.ua.entityes.Driver;
import study.ua.enums.Condition;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class DriverService {
    private DaoFactory daoFactory = new DaoFactory();
    private static DriverService instance;

    public static DriverService getInstance() {
        if (instance == null) {
            instance = new DriverService();
        }
        return instance;
    }

    public Driver getDriverByID(String id) {
        DriverDAO driverDAO = daoFactory.getDriverDAO();
        return driverDAO.getByPasport(id);
    }

    public String getDriverIdByUsername(String username) {
        DriverUserDAO driverUserDAO = daoFactory.getDriverUserDAO();
        return driverUserDAO.getDriverIdByUsername(username);
    }

    public void changeCondition(Bus bus, Condition condition) {
        BusDAO busDAO = daoFactory.getBusDAO();
        busDAO.changeCondition(bus.getNumber(), condition);
        log.info("Condition in bus with ID " + bus.getNumber() + " was was changed to " + condition.name());
    }

    public List<Bus> getBusesFromDrivers(List<Driver> drivers) {
        List<Bus> buses = new ArrayList<>();
        for (Driver driver : drivers) {
            buses.add(driver.getBus());
        }
        return buses;
    }

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
}
