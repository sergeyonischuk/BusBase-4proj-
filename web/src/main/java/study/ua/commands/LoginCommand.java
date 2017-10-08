package study.ua.commands;

import lombok.extern.log4j.Log4j;
import study.ua.entityes.User;
import study.ua.enums.UserType;
import study.ua.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Log4j
public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String login = req.getParameter("username");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        boolean validateUser = userService.validateUser(login, password);

        if (validateUser) {
            User user = userService.getUserByLogin(login);
            UserType type = userService.getUserType(login);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            session.setAttribute("username", login);

            if (type.equals(UserType.DISPATCHER)) {
                log.info("Dispatcher " + login + " logged in");
                return "dispatcherPage.jsp";
            } else if (type.equals(UserType.DRIVER)) {
                log.info("Driver " + login + " logged in");
                return "driverPage.jsp";
            }
        }
        return "loginError.jsp";
    }
}