<%@page contentType="text/html" pageEncoding="UTF-8"%> <html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title> </head>
<body> <h1>Страница входа</h1>
<center>
    <h2>Автостанция</h2>
    <form action="/busbase/login" method="post">
        <br/>Username:<input type="text" name="username">
        <br/>Password:<input type="password" name="password">
        <br/><input type="submit" value="Submit">
    </form>
</center>
</body>
</html>