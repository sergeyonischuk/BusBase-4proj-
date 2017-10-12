package study.ua.commands.dispatcher;

import study.ua.entityes.Bus;
import study.ua.entityes.Driver;
import study.ua.services.DriverService;
import study.ua.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllDriversCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DriverService driverService = DriverService.getInstance();
        List<Driver> drivers = driverService.getWorkingRollingStock();
        List<Bus> buses = driverService.getBusesFromDrivers(drivers);

        req.setAttribute("drivers", drivers);
        req.setAttribute("buses", buses);
        return "allDrivers.jsp";
    }
}