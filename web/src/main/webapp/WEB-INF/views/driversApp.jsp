<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Driver app</title>
    <link rel="stylesheet" href="/recourses/bootstrap.min.css">
    <link rel="stylesheet" href="/recourses/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/recourses/main.css">
</head>
<body>
<c:choose>
    <c:when test="${application!=null}">
        <table class="table">
            <thead>
            <tr>
                <th>id</th>
                <th>grade</th>
                <th>status</th>
                <th>Dispatch City</th>
                <th>Destination City</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${application.getId()}</td>
                <td>${application.getGrade()}</td>
                <td>${application.getStatus()}</td>
                <td>${route.getDispatchPlace()}</td>
                <td>${route.getDestinationPlace()}</td>
            </tr>
            </tbody>
        </table>
        <form action="closeApp">
            <br>
            <a href="closeApp" class="btn btn-success">Close application</a>
        </form>
        <br/>
        <br/>
        <a href="driverMain" class="btn btn-success">Back on main</a>
    </c:when>
    <c:otherwise>
        <div class="wrapper">
            <div class="alert alert-warning">
                You have no current applications
            </div>
            <a href="driverMain" class="btn btn-warning">Back on main</a>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>
