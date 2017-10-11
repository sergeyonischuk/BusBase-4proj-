<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dispatcher menu | All open applications</title>
    <link rel="stylesheet" href="/recourses/bootstrap.min.css">
    <link rel="stylesheet" href="/recourses/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/recourses/main.css">
</head>
<body>
<c:choose>
    <c:when test="${appRouteMap!=null}">
        <table class="table">
            <thead>
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
    </c:otherwise>
</c:choose>
<a href="dispatcherMain" class="btn btn-success">Back on main</a>
</body>
</html>