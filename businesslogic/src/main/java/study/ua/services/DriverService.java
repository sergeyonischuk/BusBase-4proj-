package services;

import DAO.*;
import entityes.Application;
import entityes.Bus;
import enums.Condition;
import enums.Status;

public class DriverService {
    private ConfirmedAppDAO confirmedAppDAO = new FactoryDAO().getConfirmedAppDAO();
    private BusDAO busDAO = new FactoryDAO().getBusDAO();
    private ApplicationDAO applicationDAO = new FactoryDAO().getApplicationDAO();
    private DriverUserDAO driverUserDAO = new FactoryDAO().getDriverUserDAO();

    public void closeApplication(Application application) {
        confirmedAppDAO.changeStatus(Status.CLOSED, application.getId());
    }

    public Application getApplicationByID(int appID) {
        return applicationDAO.getByID(appID);
    }

    public String getDriverIdByUsername(String username) {
        return driverUserDAO.getDriverIdByUsername(username);
    }

    private boolean checkConditions(Bus bus) {
        if (bus.getCondition() != Condition.OK) {
            busDAO.changeConditionToBroken(bus.getNumber());
            return false;
        }
        return true;
    }
}
