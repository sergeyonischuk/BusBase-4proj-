package study.ua.commands.driver;

import lombok.extern.log4j.Log4j;
import study.ua.entityes.Application;
import study.ua.entityes.User;
import study.ua.services.CommonService;
import study.ua.services.DriverService;
import study.ua.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Log4j
public class CloseApplicationCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        CommonService commonService = new CommonService();
        DriverService driverService = new DriverService();
        User user = (User) req.getSession().getAttribute("user");
        String driverID = driverService.getDriverIdByUsername(user.getLogin());
        int appID = commonService.getAppIDbyDriverID(driverID);
        Application application = driverService.getApplicationByID(appID);
        driverService.closeApplication(application);

        return "successClosedApp.jsp";
    }
}
