package main;

import entityes.Driver;
import services.CommonService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CommonService commonService = new CommonService();
        List <Driver> drivers = commonService.getWorkingRollingStock();
        System.out.println(drivers.size() + " working cars");
}
}
