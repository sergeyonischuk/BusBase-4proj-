package study.ua.services;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import study.ua.DAO.*;
import study.ua.connection.DaoFactory;
import study.ua.entityes.Application;
import study.ua.entityes.Bus;
import study.ua.enums.Condition;
import study.ua.enums.Status;

import java.util.Optional;

@Log4j
public class DriverService {
    private DaoFactory daoFactory = new DaoFactory();

    public void closeApplication(Application application) {
        ConfirmedAppDAO confirmedAppDAO = daoFactory.getConfirmedAppDAO();
        confirmedAppDAO.changeStatus(Status.CLOSED, application.getId());
        log.info("Application with ID " + application.getId() + " was closed");
    }

    public Application getApplicationByID(int appID) {
        ApplicationDAO applicationDAO = daoFactory.getApplicationDAO();
        return applicationDAO.getByID(appID);
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
}
