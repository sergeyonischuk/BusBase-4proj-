package study.ua.commands.driver;

import lombok.extern.log4j.Log4j;
import study.ua.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Log4j
public class DriverMainCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        return "driverPage.jsp";
    }
}
