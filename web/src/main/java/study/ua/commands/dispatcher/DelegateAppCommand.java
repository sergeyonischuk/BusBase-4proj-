package study.ua.commands.dispatcher;

import services.DispatcherService;
import study.ua.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelegateAppCommand implements Command {
    DispatcherService dispatcherService = new DispatcherService();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int appID = Integer.parseInt(req.getParameter("appID"));
        String driverID = req.getParameter("driverID");

        dispatcherService.delegateApp(appID, driverID);

        return "successDelegate.jsp";
    }
}
