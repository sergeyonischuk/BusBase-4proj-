package study.ua.commands.dispatcher;

import entityes.Driver;
import services.BusDriverService;
import study.ua.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllDriversCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BusDriverService busDriverService = new BusDriverService();
        List<Driver> driverList = busDriverService.getWorkingRollingStock();
        req.setAttribute("drivers", driverList);
            return "allDrivers.jsp";
    }
}