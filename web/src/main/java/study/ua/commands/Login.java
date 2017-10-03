package study.ua.commands;

import DAO.UserDAO;
import entityes.UserType;
import services.SecurityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login implements Command{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String login = req.getParameter("username");
        String password = req.getParameter("password");
        UserDAO userDAO = new UserDAO();
        SecurityService securityService = new SecurityService();
        boolean validateUser = securityService.checkUser(login, password);

        if (validateUser) {
            UserType type = userDAO.getUserType(login, password);
                req.setAttribute("usertype", type);
                req.getSession().setAttribute("type", type.name());
                if (type.equals(UserType.DISPATCHER)) {
                    return "dispatcherPage.jsp";
                } else if (type.equals(UserType.DRIVER)) {
                    return "driverPage.jsp";
                }
            }
        return "loginError.jsp";
    }
}