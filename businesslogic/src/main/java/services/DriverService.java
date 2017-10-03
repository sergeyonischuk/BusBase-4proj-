package services;

import DAO.BusDAO;
import DAO.ConfirmedAppDAO;
import DAO.DAOFactory;
import entityes.Application;
import entityes.Bus;
import enums.Condition;
import enums.Status;

public class DriverService {
    ConfirmedAppDAO confirmedAppDAO = new ConfirmedAppDAO();
    BusDAO busDAO = new BusDAO();

    public void closeApplication(Application application) {
        confirmedAppDAO.changeStatus(Status.CLOSED, application.getId());
    }

    private boolean checkConditions(Bus bus) {
        if (bus.getCondition() != Condition.OK) {
            busDAO.changeConditionToBroken(bus.getNumber());
            return false;
        }
        return true;
    }

}
