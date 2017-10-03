package services;

import DAO.*;
import entityes.Application;
import entityes.Bus;
import entityes.Driver;
import enums.Condition;
import enums.Grade;
import enums.Status;

import java.util.List;

public class DispatcherService {
    ConfirmedAppDAO confirmedAppDAO = new ConfirmedAppDAO();
    ApplicationDAO applicationDAO = new ApplicationDAO();
    DriverDAO driverDAO = new DriverDAO();
    BusDriverDAO busDriverDAO = new BusDriverDAO();
    BusDAO busDAO = new BusDAO();

    public List<Application> getApplicationsWithStatus(Status status) {
        return applicationDAO.getAllwithStatus(status);
    }

    public void delegateApp(int appID, String driverID) {
        Application app = applicationDAO.getByID(appID);
        Driver driver = driverDAO.getByPasport(driverID);
        driver.setBus(getBusByDriverID(driver.getPasportID()));

        if (checkCondition(driver.getBus()) && checkGrade(app.getGrade(), driver.getBus())) {
            confirmedAppDAO.add(app, driver);
            confirmedAppDAO.changeStatus(Status.IN_PROGRES, app.getId());
        } else {
            System.out.println("the requirements do not match the application");
        }

    }

    private boolean checkCondition(Bus bus) {
        if (bus.getCondition() == Condition.OK) {
            return true;
        }
        return false;
    }

    private boolean checkGrade(Grade neededGrade, Bus bus) {
        if (neededGrade == bus.getGrade()) {
            return true;
        }
        return false;
    }

    private Bus getBusByDriverID(String passport) {
        return busDAO.getByID(busDriverDAO.getBusNumberByDriverID(passport));
    }
}