//package study.ua.filter;
//
//import lombok.extern.log4j.Log4j;
//import study.ua.entityes.User;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Set;
//
//@Log4j
//@WebFilter(filterName = "/busbase/*", urlPatterns = { "/*" })
//public class MainFilter implements Filter {
//    private FilterConfig filterConfig;
//    private Set<String> dispatcherURI = new HashSet<>();
//    private Set<String> driverURI = new HashSet<>();
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        this.filterConfig = filterConfig;
//
//        dispatcherURI.add("/busbase/index");
//        dispatcherURI.add("/busbase/allDrivers");
//        dispatcherURI.add("/busbase/allOpenApp");
//        dispatcherURI.add("/busbase/appStatusIsNotOpen");
//        dispatcherURI.add("/busbase/dispatcherPage");
//        dispatcherURI.add("/busbase/loginError");
//        dispatcherURI.add("/busbase/logout");
//        dispatcherURI.add("/busbase/notfound");
//        dispatcherURI.add("/busbase/successDelegate");
//
//        driverURI.add("/busbase/index");
//        driverURI.add("/busbase/driverPage");
//        driverURI.add("/busbase/successClosedApp");
//        driverURI.add("/busbase/loginError");
//        driverURI.add("/busbase/logout");
//        driverURI.add("/busbase/notfound");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession(false);
//        request.setCharacterEncoding("utf-8");
//
//        if(session != null) {
//            Object sessionUser = session.getAttribute("user");
//            if(sessionUser != null) {
//                User user = (User) sessionUser;
//                String uri = request.getRequestURI();
//            } else {
//                request.getRequestDispatcher("backToLogin").forward(servletRequest, servletResponse);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//
//        @Override
//    public void destroy() {
////        this.filterConfig = null;
//    }
//}
