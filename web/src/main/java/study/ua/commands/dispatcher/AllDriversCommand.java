package study.ua.commands.dispatcher;

import lombok.extern.log4j.Log4j;
import study.ua.entityes.Bus;
import study.ua.entityes.Driver;
import study.ua.services.CommonService;
import study.ua.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Log4j
public class AllDriversCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        CommonService commonService = new CommonService();
        List<Driver> drivers = commonService.getWorkingRollingStock();
        List<Bus> buses = commonService.getBusesFromDrivers(drivers);

        req.setAttribute("drivers", drivers);
        req.setAttribute("buses", buses);
            return "allDrivers.jsp";
    }
}