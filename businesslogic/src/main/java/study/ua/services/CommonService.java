package services;

import DAO.*;
import entityes.Bus;
import entityes.Driver;
import enums.Condition;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CommonService {
    private BusDAO busDAO = new FactoryDAO().getBusDAO();
    private DriverDAO driverDAO = new FactoryDAO().getDriverDAO();
    private BusDriverDAO busDriverDAO = new FactoryDAO().getBusDriverDAO();
    private ConfirmedAppDAO confirmedAppDAO = new FactoryDAO().getConfirmedAppDAO();

    private static final Logger logger = Logger.getLogger(CommonService.class);

    public List<Driver> getWorkingRollingStock() {
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
        return confirmedAppDAO.getApplicationIDByDriverID(id);
    }

    public List<Bus> getBusesFromDrivers(List<Driver> drivers) {
        List<Bus> buses = new ArrayList<>();
        for (Driver driver : drivers) {
            buses.add(driver.getBus());
        }
        return buses;
    }

}
