<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Driver menu page</title>
</head>
<body>

<br>
<a href="driverApp">Show your application</a><br>
<br>
Change Bus condition status
<br>
<form action="changeBusCondition">
    <p><label>
        <select name="condition">
            <option selected value="OK">OK</option>
            <option value="REPAIR_NEEDED">REPAIR_NEEDED</option>
        </select>
    </label></p>
    <br>
    <p><input type="submit" value="Change"></p>
</form>
</body>
</html>
