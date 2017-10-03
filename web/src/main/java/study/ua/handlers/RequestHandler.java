package study.ua.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RequestHandler {

    String processRequest(HttpServletRequest request, HttpServletResponse response);
}
