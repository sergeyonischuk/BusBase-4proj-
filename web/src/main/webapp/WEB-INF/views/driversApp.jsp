<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Driver Application</title>
</head>
<body>
<form action="closeApp">
<c:choose>
    <c:when test="${application!=null}">
        <table>
            <tr>
                <th>id</th>
                <th>grade</th>
                <th>status</th>
                <th>Dispatch City</th>
                <th>Destination City</th>
            </tr>
            <tr>
                <td>${application.getId()}</td>
                <td>${application.getGrade()}</td>
                <td>${application.getStatus()}</td>
                <td>${route.getDispatchPlace()}</td>
                <td>${route.getDestinationPlace()}</td>
        </table>
        <br />
        Close application
        <br>
        <p><input type="submit" value="closeApp"></p>
        <br>
        <a href="driverMain">Back on main</a>
    </c:when>
    <c:otherwise>
        You have no current applications
        <br />
        <a href="driverMain">Back on main</a>
    </c:otherwise>
</c:choose>
</form>
</body>
</html>
