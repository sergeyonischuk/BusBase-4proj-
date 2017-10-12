package study.ua.commands.driver;

import study.ua.entityes.Application;
import study.ua.entityes.Route;
import study.ua.enums.Status;
import study.ua.services.ApplicationService;
import study.ua.services.RouteService;
import study.ua.services.DriverService;
import study.ua.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DriverAppCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DriverService driverService = DriverService.getInstance();
        ApplicationService applicationService = ApplicationService.getInstance();
        RouteService routeService = RouteService.getInstance();

        String username = (String) req.getSession().getAttribute("username");
        String driverID = driverService.getDriverIdByUsername(username);
        int appID = applicationService.getAppIDbyDriverID(driverID);
        Application application = applicationService.getApplicationByID(appID);

        if (application.getStatus().equals(Status.IN_PROGRES)) {
            Route route = routeService.getRouteByID(application.getRouteID());
            req.setAttribute("route", route);
            req.setAttribute("application", application);
        }
        return "driversApp.jsp";
    }
}
