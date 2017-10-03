<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="allOpenApp">
    <table>
        <tr>
            <th>id</th>
            <th>route_id</th>
            <th>grade</th>
            <th>status</th>
        </tr>
        <c:forEach items="${applications}" var="i">
            <tr>
                <td>
                    <a href="application/${i.getId()}">
                            ${i.getDescription()}</a></td>
                            <td>${i.getPrice()}</td>
                            <td>${i.getCategory()}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
