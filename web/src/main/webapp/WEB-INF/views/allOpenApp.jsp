<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<meta charset="UTF-8">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dispatcher menu | All open applications</title>
</head>
<body>
<c:choose>
    <c:when test="${appRouteMap!=null}">
        <table>
            <tr>
                <th>id</th>
                <th>grade</th>
                <th>status</th>
                <th>Dispatch City</th>
                <th>Destination City</th>
            </tr>
            <c:forEach items="${appRouteMap}" var="i" varStatus="loopCount">
            <tr>
                <td>${i.key.getId()}</td>
                <td>${i.key.getGrade()}</td>
                <td>${i.key.getStatus()}</td>
                <td>${i.value.getDispatchPlace()}</td>
                <td>${i.value.getDestinationPlace()}</td>
            </c:forEach>
            </tr>
        </table>
        <br/>
    </c:when>
    <c:otherwise>
        There is no open applications
        <br />
        <a href="dispatcherMain">Back on main</a>
    </c:otherwise>
</c:choose>
<a href="dispatcherMain">Back on main</a>
</body>
</html>