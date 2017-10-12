<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
            </thead>
            <tbody>
            <c:forEach items="${appRouteMap}" var="i" varStatus="loopCount">
                <tr>
                    <td>${i.key.getId()}</td>
                    <td>${i.key.getGrade()}</td>
                    <td>${i.key.getStatus()}</td>
                    <td>${i.value.getDispatchPlace()}</td>
                    <td>${i.value.getDestinationPlace()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br/>
    </c:when>
    <c:otherwise>
        There is no open applications
        <br/>
    </c:otherwise>
</c:choose>
<div class="wrapper dispatcher">
    <form method="POST" action="delegateApp" class="form form-signin">
        <input type="text" name="appID" class="form-control" placeholder="Application ID" required>
        <input type="text" name="driverID" class="form-control" placeholder="Driver ID" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="Delegate" name="delegateApp">Delegate
        </button>
    </form>
</div>
<a href="dispatcherMain" class="btn btn-success">Back on main</a>
</body>
</html>