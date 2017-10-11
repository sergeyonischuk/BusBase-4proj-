<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Title</title>
	<link rel="stylesheet" href="/recourses/bootstrap.min.css">
	<link rel="stylesheet" href="/recourses/bootstrap-theme.min.css">
	<link rel="stylesheet" href="/recourses/main.css">
</head>
<body>
	<div class="wrapper dispatcher">
		<div class="alert alert-success">
			Hello, dispatcher!
		</div>

		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Dispatcher menu page</h3>
			</div>

			<div class="panel-body">
				<a href="allDrivers" class="btn btn-link">List drivers »</a>
			</div>

			<div class="panel-body">
				<a href="allOpenApp" class="btn btn-link">List of open applications »</a>
			</div>
		</div>

		<form method = "POST" action = "delegateApp" class="form form-signin">
			<input type="text" name="appID" class="form-control" placeholder="Delegate Application Application ID" required>
			<input type="text" name="driverID" class="form-control" placeholder="Driver ID" required>

			<button class="btn btn-lg btn-primary btn-block" type="submit" value="Delegate" name="delegateApp">Delegate</button>
		</form>
		<a href="logout" class="btn btn-danger">Logout</a>
	</div>
</body>
</html>
