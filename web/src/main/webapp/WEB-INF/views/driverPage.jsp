<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
driver page
<a href="driversApp.jsp">Show application</a><br>
<br>
Change Bus condition status
<br>
<form action="repair" method="post">
    <p><select name="condition">
        <option disabled>Choose condition</option>
        <option selected value="OK">OK</option>
        <option value="REPAIR_NEEDED">REPAIR_NEEDED</option>
    </select></p>
    <p><input type="submit" value="Change"></p>
</form>
</body>
</html>
