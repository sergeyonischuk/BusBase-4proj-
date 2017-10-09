package study.ua.services;

import study.ua.DAO.*;
import study.ua.connection.DaoFactory;
import study.ua.entityes.Application;
import study.ua.entityes.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteService {
    private DaoFactory daoFactory = new DaoFactory();


    public Route getRouteByID(int id) {
        RouteDAO routeDAO = daoFactory.getRouteDAO();
        return routeDAO.getByID(id);
    }

    public List<Route> getRoutesFromApp(List<Application> applications) {
        RouteDAO routeDAO = daoFactory.getRouteDAO();
        List<Route> routes = new ArrayList<>();
        for (Application currentApp : applications) {
            Route route = routeDAO.getByID(currentApp.getRouteID());
            routes.add(route);
        }
        return routes;
    }
}
