package study.ua.commands;

import javax.servlet.http.HttpServletRequest;

abstract public class CommonCommand {

    protected String errorPageWithMessage(HttpServletRequest request, String message) {
        request.setAttribute("message", message);
        return "notfound.jsp";
    }
}
