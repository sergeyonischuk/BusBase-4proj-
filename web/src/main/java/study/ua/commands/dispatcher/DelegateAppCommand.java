package study.ua.commands.dispatcher;

import lombok.extern.log4j.Log4j;
import study.ua.entityes.Application;
import study.ua.entityes.Driver;
import study.ua.enums.Status;
import study.ua.services.CommonService;
import study.ua.services.DispatcherService;
import study.ua.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Log4j
public class DelegateAppCommand implements Command {
    private DispatcherService dispatcherService = new DispatcherService();
    private CommonService commonService = new CommonService();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String reqParam = req.getParameter("appID");
        if (!isDigit(reqParam)) {
            return "appNotFound.jsp";
        }
            int appID = Integer.parseInt(req.getParameter("appID"));
            String driverID = req.getParameter("driverID");
        return checkData(appID, driverID);
    }

    private String checkData(int appID, String driverID) {
        Application application = commonService.getAppByID(appID);
        Driver driver = dispatcherService.getDriverByID(driverID);
        if (driver == null) {
            return "driverNotFound.jsp";
        }
        if (application == null) {
            return "appNotFound.jsp";
        } else if (application.getStatus().equals(Status.OPEN)) {
            dispatcherService.delegateApp(appID, driverID);
            return "successDelegate.jsp";
        } else {
            return "appStatusIsNotOpen.jsp";
        }
    }

    private boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
