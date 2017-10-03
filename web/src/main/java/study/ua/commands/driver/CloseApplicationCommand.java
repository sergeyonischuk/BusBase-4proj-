package study.ua.commands.driver;

import DAO.ConfirmedAppDAO;
import entityes.Application;
import services.DriverService;
import study.ua.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CloseApplicationCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ConfirmedAppDAO confirmedAppDAO = new ConfirmedAppDAO();
        DriverService driverService = new DriverService();
        String login = (String) req.getSession().getAttribute("login");
        Application app = confirmedAppDAO.getApplicationByDriverID(login);

        driverService.closeApplication(app);
        return "successClosedApp.jsp";
    }
}
