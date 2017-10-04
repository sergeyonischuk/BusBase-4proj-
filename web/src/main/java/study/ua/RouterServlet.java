package study.ua;

import study.ua.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static study.ua.GlobalRequestHandler.HANDLERS;
import static study.ua.GlobalRequestHandler.POST_HANDLERS;

@WebServlet("/busbase/*")
public class RouterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp, HANDLERS);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp, POST_HANDLERS);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response, Map<String, Command>
            mapping) throws ServletException, IOException {
        Command command = mapping.get(request.getRequestURI().replace("/busbase/", "")
                .replaceAll("/\\d+", ""));
        String pageName = command.execute(request, response);

        try {
            request.getRequestDispatcher("/WEB-INF/views/" + pageName).forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}