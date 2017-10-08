package study.ua;

import study.ua.commands.Command;
import study.ua.commands.LoginCommand;
import study.ua.commands.dispatcher.*;
import study.ua.commands.driver.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class GlobalRequestHandler implements Command {

    final static Map<String, Command> GET_HANDLERS = new HashMap<>();
    final static Map<String, Command> POST_HANDLERS = new HashMap<>();

    static {
        GET_HANDLERS.put("allDrivers", new AllDriversCommand());
        GET_HANDLERS.put("allOpenApp", new AllOpenAppCommand());
        GET_HANDLERS.put("driverApp", new DriverAppCommand());
        GET_HANDLERS.put("delegateApp", new DelegateAppCommand());
        GET_HANDLERS.put("closeApp", new CloseApplicationCommand());
        GET_HANDLERS.put("dispatcherMain", new DispatcherMainCommand());
        GET_HANDLERS.put("driverMain", new DriverMainCommand());
        GET_HANDLERS.put("changeBusCondition", new BusConditionCommand());

        POST_HANDLERS.put("menu", new LoginCommand());
        POST_HANDLERS.put("delegateApp", new DelegateAppCommand());

    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        return "notfound.jsp";
    }
}