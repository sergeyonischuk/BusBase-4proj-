package services;

import DAO.*;
import entityes.Application;
import entityes.Bus;
import entityes.Driver;
import entityes.Route;
import enums.Condition;
import enums.Grade;
import enums.Status;

import java.util.ArrayList;
import java.util.List;

public class DispatcherService {
    private ConfirmedAppDAO confirmedAppDAO = new FactoryDAO().getConfirmedAppDAO();
    private ApplicationDAO applicationDAO = new FactoryDAO().getApplicationDAO();
    private DriverDAO driverDAO = new FactoryDAO().getDriverDAO();
    private BusDriverDAO busDriverDAO = new FactoryDAO().getBusDriverDAO();
    private BusDAO busDAO = new FactoryDAO().getBusDAO();
    private RouteDAO routeDAO = new FactoryDAO().getRouteDAO();

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

    public List<Application> getApplicationsWithStatus(Status status) {
        return applicationDAO.getAllwithStatus(status);
    }

    public List<Route> getRoutesFromApp(List<Application> applications) {
        List<Route> routes = new ArrayList<>();
        for (Application currentApp : applications) {
            Route route = routeDAO.getByID(currentApp.getRouteID());
            routes.add(route);
        }
        return routes;
    }

    private boolean checkCondition(Bus bus) {
        return bus.getCondition() == Condition.OK;
    }

    private boolean checkGrade(Grade neededGrade, Bus bus) {
        return neededGrade == bus.getGrade();
    }

    private Bus getBusByDriverID(String passport) {
        return busDAO.getByID(busDriverDAO.getBusNumberByDriverID(passport));
    }
}