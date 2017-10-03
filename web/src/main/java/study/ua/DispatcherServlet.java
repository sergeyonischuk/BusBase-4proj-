package study.ua;

import DAO.ApplicationDAO;
import DAO.BusDriverDAO;
import DAO.DriverDAO;
import entityes.Application;
import enums.Status;
import services.DispatcherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
    DispatcherService dispatcherService = new DispatcherService();
    DriverDAO driverDAO = new DriverDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String status = req.getParameter("status");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        if (status.equals("OPEN")) {
            List <Application> list = dispatcherService.getApplicationsWithStatus(Status.OPEN);
            if (list.size() == 0) {
                out.println("nothing to show");
            }
            for (int i = 0; i < list.size(); i++) {
                Application current = list.get(i);
                out.println(current.getId() + ". RouteID: " + current.getRouteID() + ", Grade: " + current.getGrade().name() + ", Status: " + current.getStatus());
            }

        }
        out.print("<br>");
        out.println("<a href='http://localhost:8080/index.jsp'>" + "Back on main page" + "</a>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
    }
}
