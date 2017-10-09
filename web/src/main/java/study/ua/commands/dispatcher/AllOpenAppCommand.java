package study.ua.commands.dispatcher;

import study.ua.entityes.Application;
import study.ua.entityes.Route;
import study.ua.enums.Status;
import study.ua.services.ApplicationService;
import study.ua.commands.Command;
import study.ua.services.RouteService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllOpenAppCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ApplicationService applicationService = new ApplicationService();
        RouteService routeService = new RouteService();

        List<Application> applications = applicationService.getApplicationsWithStatus(Status.OPEN);
        List<Route> routes = routeService.getRoutesFromApp(applications);
        Map<Application, Route> appRouteMap = new HashMap<>();

        for (int i = 0; i < applications.size(); i++) {
            appRouteMap.put(applications.get(i), routes.get(i));
        }
        req.setAttribute("applications", applications);
        req.setAttribute("routes", routes);
        req.setAttribute("appRouteMap", appRouteMap);

        return "allOpenApp.jsp";
    }
}