package study.ua.commands.driver;

import lombok.extern.log4j.Log4j;
import study.ua.entityes.Application;
import study.ua.entityes.Route;
import study.ua.enums.Status;
import study.ua.services.CommonService;
import study.ua.services.DriverService;
import study.ua.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Log4j
public class DriverAppCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DriverService driverService = new DriverService();
        CommonService commonService = new CommonService();

        String username = (String) req.getSession().getAttribute("username");
        String driverID = driverService.getDriverIdByUsername(username);
        int appID = commonService.getAppIDbyDriverID(driverID);
        Application application = driverService.getApplicationByID(appID);
        if (application.getStatus().equals(Status.IN_PROGRES)) {
            Route route = commonService.getRouteByID(application.getRouteID());
            req.setAttribute("route", route);
            req.setAttribute("application", application);
        }
        return "driversApp.jsp";
    }
}
