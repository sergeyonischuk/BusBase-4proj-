package main;

import DAO.*;
import entityes.Application;
import entityes.Driver;
import entityes.Route;
import enums.Status;
import services.BusDriverService;
import services.DispatcherService;
import services.DriverService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BusDriverService busDriverService = new BusDriverService();
        List <Driver> drivers = busDriverService.getWorkingRollingStock();
        System.out.println(drivers.size() + " working cars");
}
}
