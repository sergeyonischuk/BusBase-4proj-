package study.ua.commands.dispatcher;

import lombok.extern.log4j.Log4j;
import study.ua.entityes.Application;
import study.ua.entityes.Route;
import study.ua.enums.Status;
import study.ua.services.DispatcherService;
import study.ua.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Log4j
public class AllOpenAppCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DispatcherService dispatcherService = new DispatcherService();
        List<Application> applications = dispatcherService.getApplicationsWithStatus(Status.OPEN);
        List<Route> routes = dispatcherService.getRoutesFromApp(applications);
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