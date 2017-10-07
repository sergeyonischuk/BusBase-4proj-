<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<meta charset="UTF-8">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dispatcher menu | All open applications</title>
</head>
<body>
<form action="allOpenApp">
    <table>
        <tr>
            <th>id</th>
            <th>grade</th>
            <th>status</th>
            <th>Dispatch City</th>
            <th>Destination City</th>
        </tr>
        <c:forEach items="${applications}" var="i" varStatus="loopCount">
            <tr>
                <td>${i.getId()}</td>
                <td>${i.getGrade()}</td>
                <td>${i.getStatus()}</td>
                <%--<td>routes.getDispatchPlace: ${loopCount.routes} </td>--%>
        </c:forEach>
    </table>
</form>
<a href="dispatcherMain">Back on main</a>
</body>
</html>
