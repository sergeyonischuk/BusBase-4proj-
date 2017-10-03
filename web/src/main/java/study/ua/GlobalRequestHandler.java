package study.ua;

import study.ua.commands.Command;
import study.ua.commands.Login;
import study.ua.commands.dispatcher.AllDriversCommand;
import study.ua.commands.dispatcher.AllOpenAppCommand;
import study.ua.commands.dispatcher.DelegateAppCommand;
import study.ua.commands.driver.CloseApplicationCommand;
import study.ua.commands.driver.DriversApplicationCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GlobalRequestHandler implements Command {

    final static Map<String, Command> HANDLERS = new HashMap<>();
    static {
//        handlers.put("/driver", new DriverRequestHandler());
        HANDLERS.put("login", new Login());
        HANDLERS.put("allDrivers", new AllDriversCommand());
        HANDLERS.put("allOpenApp", new AllOpenAppCommand());
        HANDLERS.put("delegateApp", new DelegateAppCommand());
        HANDLERS.put("closeApp", new CloseApplicationCommand());
        HANDLERS.put("driversApp", new DriversApplicationCommand());
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        return "notfound.jsp";
    }
}
