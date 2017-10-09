package study.ua.services;

import lombok.extern.log4j.Log4j;
import study.ua.DAO.*;
import study.ua.connection.DaoFactory;
import study.ua.entityes.Application;
import study.ua.entityes.Bus;
import study.ua.entityes.Driver;
import study.ua.enums.Condition;
import study.ua.enums.Grade;
import study.ua.enums.Status;

@Log4j
public class DispatcherService {
    private DaoFactory daoFactory = new DaoFactory();

    public void delegateApp(int appID, String driverID) {
        ApplicationDAO applicationDAO = daoFactory.getApplicationDAO();
        DriverDAO driverDAO = daoFactory.getDriverDAO();
        ConfirmedAppDAO confirmedAppDAO = daoFactory.getConfirmedAppDAO();

        Application app = applicationDAO.getByID(appID);
        Driver driver = driverDAO.getByPasport(driverID);
        driver.setBus(getBusByDriverID(driver.getPasportID()));

        if (checkCondition(driver.getBus()) && checkGrade(app.getGrade(), driver.getBus())) {
            confirmedAppDAO.add(app, driver);
            confirmedAppDAO.changeStatus(Status.IN_PROGRES, app.getId());

            log.info("Application with id " + app.getId() + " was delegated to driver with id - " + driver.getPasportID());
        } else {
            log.info("Application with id " + app.getId() + " was NOT delegated to driver with id - " + driver.getPasportID());
        }
    }

    public Bus getBusByDriverID(String passport) {
        BusDAO busDAO = daoFactory.getBusDAO();
        BusDriverDAO busDriverDAO = daoFactory.getBusDriverDAO();
        return busDAO.getByID(busDriverDAO.getBusNumberByDriverID(passport));
    }

    private boolean checkCondition(Bus bus) {
        return bus.getCondition() == Condition.OK;
    }

    private boolean checkGrade(Grade neededGrade, Bus bus) {
        return neededGrade == bus.getGrade();
    }


}