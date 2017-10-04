package main;

import DAO.*;
import entityes.Application;
import entityes.Driver;
import entityes.Route;
import enums.Status;
import services.DispatcherService;
import services.DriverService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        ApplicationDAO applicationDAO = new ApplicationDAO();
//
//        DispatcherService dispatcherService = new DispatcherService();
//        System.out.println(dispatcherService.getApplicationsWithStatus(Status.OPEN).get(0).getId());
//        System.out.println(dispatcherService.getApplicationsWithStatus(Status.OPEN).get(0).getRouteID());
//        System.out.println(dispatcherService.getApplicationsWithStatus(Status.OPEN).get(0).getGrade());


//        dispatcherService.delegateApp(20, "КУ461931");
//        dispatcherService.delegateApp(20, "МИ345692");
//
//        DriverService driverService = new DriverService();
//        driverService.closeApplication(applicationDAO.getByID(20));

//        DriverDAO driverDAO = new DriverDAO();
//        List <Application> list = dispatcherService.getApplicationsWithStatus(Status.OPEN);
//        System.out.println(list.get(0).getId());
//        System.out.println(list.get(1).getStatus());
//        System.out.println(list.get(2).getRouteID());

        UserDAO userDAO = new FactoryDAO().getUserDAO();

        boolean test = userDAO.checkUserByPassword("overlord", "12345");
        System.out.println(test);

//        System.out.println(driverDAO.getByPasport("ТЕ231321").getName() + " " + driverDAO.getByPasport("ТЕ231321").getPasportID());
}
}