package services;

import DAO.BusDAO;
import DAO.BusDriverDAO;
import entityes.Bus;
import entityes.Driver;
import enums.Condition;
import enums.Grade;

import java.util.ArrayList;
import java.util.List;

public class BusDriverService {
        BusDAO busDAO = new BusDAO();
        BusDriverDAO busDriverDAO = new BusDriverDAO();

    public List<String> allRollingStockForPrint(List<Driver> drivers) {
        List<String> res = new ArrayList<>();

        for(int i = 0; i < drivers.size(); i++) {
            res.add(getRollingStockInfo(drivers.get(i)));
        }
        return res;
    }

    public List<Driver> getWorkingRollingStock() {
        List<Bus> busesByGrade = busDAO.getAll();
        List<Driver> drivers = new ArrayList<>();

        for (int i = 0; i < busesByGrade.size(); i++) {
            String busNumber = busesByGrade.get(i).getNumber();
            Bus bus = busDAO.getByID(busNumber);
            if (bus.getCondition() != Condition.REPAIR_NEEDED) {
                drivers.add(busDriverDAO.getDriverIdByBusNumber(busNumber));
            }
        }
        return drivers;
    }


    public String getRollingStockInfo(Driver driver) {
        Bus bus = driver.getBus();

        String res = driver.getName() + " " + driver.getSecondName() + " " + driver.getPasportID()
                + ". Bus: " + bus.getModel() + ", " + bus.getNumber() + ". Grade: " + bus.getGrade().name() + ". Condition: " + bus.getCondition().name() + "\n";
        return res;
    }
}
