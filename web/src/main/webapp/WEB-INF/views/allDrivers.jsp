<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dispatcher menu | All drivers list</title>
</head>
<body>
<form action="allDrivers">
    <table>
        <tr>
            <th>id_passport</th>
            <th>name</th>
            <th>surname</th>
            <th>bus model</th>
            <th>bus grade</th>
        </tr>
        <c:forEach items="${drivers}" var="i">
            <tr>
                <td>${i.getPasportID()}</td>
                <td>${i.getName()}</td>
                <td>${i.getSecondName()}</td>
                <td>${i.getBus().getModel()}</td>
                <td>${i.getBus().getGrade()}</td>
            </tr>
        </c:forEach>
    </table>
</form>
<a href="dispatcherMain">Back on main</a>
</body>
</html>
