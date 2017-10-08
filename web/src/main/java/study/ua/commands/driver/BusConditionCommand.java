package study.ua.commands.driver;

import lombok.extern.log4j.Log4j;
import study.ua.commands.Command;
import study.ua.entityes.Bus;
import study.ua.entityes.Driver;
import study.ua.entityes.User;
import study.ua.enums.Condition;
import study.ua.services.DispatcherService;
import study.ua.services.DriverService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Log4j
public class BusConditionCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DriverService driverService = new DriverService();
        DispatcherService dispatcherService = new DispatcherService();
        String needed_condition = (String) req.getParameter("condition");
        Condition condition = Condition.valueOf(needed_condition);
        User user = (User) req.getSession().getAttribute("user");
        String driverID = driverService.getDriverIdByUsername(user.getLogin());
        Bus bus = dispatcherService.getBusByDriverID(driverID);

        if (!bus.getCondition().equals(condition)) {
            driverService.changeCondition(bus, condition);
            return "successChangedCondition.jsp";
        } else {
            return "currentCondition.jsp";
        }
    }
}
