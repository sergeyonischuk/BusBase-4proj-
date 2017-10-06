<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
Current applications:
<form action="allDriverApp">
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
</body>
</html>
