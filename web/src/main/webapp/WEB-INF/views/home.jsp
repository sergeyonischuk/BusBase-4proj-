<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home page | Authorization</title>
	<link rel="stylesheet" href="/recourses/bootstrap.min.css">
	<link rel="stylesheet" href="/recourses/bootstrap-theme.min.css">
	<link rel="stylesheet" href="/recourses/main.css">
</head>
<body>
	<div class="wrapper login">
		<h2>Please sign in</h2>

		<form action="busbase/menu" method="post" class="form form-signin">
			<input type="text" name="username" class="form-control" placeholder="Login" required>
			<input type="password" name="password" class="form-control" placeholder="Password" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">Sign in</button>
		</form>
	</div>
</body>
</html>
