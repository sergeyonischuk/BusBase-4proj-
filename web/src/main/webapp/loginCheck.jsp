<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>JSP Page</title>
</head>
<body>
<% String username=request.getParameter("username");
String password=request.getParameter("password");

    //http://mrbool.com/how-to-create-a-login-form-with-jsp/25685
    //http://o7planning.org/en/10285/create-a-simple-java-web-application-using-servlet-jsp-and-jdbc
if((username.equals("admin") && password.equals("admin"))) {
    session.setAttribute("username",username);
    response.sendRedirect("dispatcherPage.jsp"); }
    else
        response.sendRedirect("loginError.jsp"); %>
</body>
</html>