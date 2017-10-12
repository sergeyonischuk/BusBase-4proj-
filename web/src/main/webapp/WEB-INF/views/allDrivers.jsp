<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dispatcher menu | All drivers list</title>
    <link rel="stylesheet" href="/recourses/bootstrap.min.css">
    <link rel="stylesheet" href="/recourses/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/recourses/main.css">
</head>
<body>
<form action="allDrivers">
<c:choose>
    <c:when test="${drivers!=null}">
    <table class="table">
        <thead>
        <tr>
            <th>Passport</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Bus model</th>
            <th>Bus grade</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${drivers}" var="i">
            <tr>
                <td>${i.getPasportID()}</td>
                <td>${i.getName()}</td>
                <td>${i.getSecondName()}</td>
                <td>${i.getBus().getModel()}</td>
                <td>${i.getBus().getGrade()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:when>
    <c:otherwise>
        There is no open drivers in database
        <br />
    </c:otherwise>
</c:choose>
</form>
<div class="wrapper dispatcher">
<form method = "POST" action = "delegateApp" class="form form-signin">
    <input type="text" name="appID" class="form-control" placeholder="Application ID" required>
    <input type="text" name="driverID" class="form-control" placeholder="Driver ID" required>
    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Delegate" name="delegateApp">Delegate</button>
</form>
</div>
<a href="dispatcherMain" class="btn btn-success">Back on main</a>
</body>
</html>
