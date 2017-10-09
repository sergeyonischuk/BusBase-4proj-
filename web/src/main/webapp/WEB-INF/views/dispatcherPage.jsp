<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dispatcher menu | All open applications</title>
</head>
<body>
<b>Hello, dispatcher!</b>
    <br>
Dispatcher menu page
    <br>
<a href="allDrivers">List drivers</a><br>
<a href="allOpenApp">List of open applications</a><br>

<form method = "POST" action = "delegateApp">
    <br>
    Delegate Application
    <br>
    Application ID
    <label>
        <input type="text" name="appID">
    </label>
    <br>
    Driver ID
    <label>
        <input type="text" name="driverID">
    </label>
    <br>
    <input type="submit" name = "delegateApp" value="Delegate"><br>
</form>
</body>
</html>
