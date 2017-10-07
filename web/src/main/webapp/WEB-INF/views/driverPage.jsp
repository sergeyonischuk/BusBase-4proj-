<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<form action="driverApp">
driver page
<br>
Your application:
    <br>
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
        <c:forEach items="${applications}" var="i" varStatus="loopCount">
        <tr>
            <td>${i.getId()}</td>
            <td>${i.getGrade()}</td>
            <td>${i.getStatus()}</td>
                <%--<td>routes.getDispatchPlace: ${loopCount.routes} </td>--%>
            </c:forEach>
    </table>
        <br />
        <p><input type="submit" value="closeApp">Close Application</p>
    </c:when>
    <c:otherwise>
    You have no current applications
        <br />
    </c:otherwise>
</c:choose>
</form>
<br>
Change Bus condition status
<br>
<form action="repair" method="post">
    <p><select name="condition">
        <option disabled>Choose condition</option>
        <option selected value="OK">OK</option>
        <option value="REPAIR_NEEDED">REPAIR_NEEDED</option>
    </select></p>
    <br>
    Change bus condition status
    <p><input type="submit" value="Change"></p>
</form>
</body>
</html>
