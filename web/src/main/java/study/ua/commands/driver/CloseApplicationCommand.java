package study.ua.commands.driver;

import study.ua.entityes.Application;
import study.ua.entityes.User;
import study.ua.services.ApplicationService;
import study.ua.services.DriverService;
import study.ua.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CloseApplicationCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ApplicationService applicationService = ApplicationService.getInstance();
        DriverService driverService = DriverService.getInstance();

        User user = (User) req.getSession().getAttribute("user");
        String driverID = driverService.getDriverIdByUsername(user.getLogin());
        int appID = applicationService.getAppIDbyDriverID(driverID);
        Application application = applicationService.getApplicationByID(appID);
        applicationService.closeApplication(application);

        return "successClosedApp.jsp";
    }
}
