package study.ua.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DriverRequestHandler implements RequestHandler {
    @Override
    public String processRequest(HttpServletRequest request, HttpServletResponse response) {

        return "driverpage.jsp";
    }
}
