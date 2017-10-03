package study.ua.commands.dispatcher;

import DAO.ApplicationDAO;
import entityes.Application;
import enums.Status;
import study.ua.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllOpenAppCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ApplicationDAO applicationDAO = new ApplicationDAO();
        List<Application> applications = applicationDAO.getAllwithStatus(Status.OPEN);
        req.setAttribute("applications", applications);

        return "allOpenApp.jsp";
    }
}