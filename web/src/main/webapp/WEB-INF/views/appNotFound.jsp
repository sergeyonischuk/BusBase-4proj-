<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>App not found</title>
	<link rel="stylesheet" href="/recourses/bootstrap.min.css">
	<link rel="stylesheet" href="/recourses/bootstrap-theme.min.css">
	<link rel="stylesheet" href="/recourses/main.css">
</head>
<body>
	<div class="wrapper">
		<div class="alert alert-danger">
			Application with that ID does not exist in database.
		</div>

		<a href="dispatcherMain" class="btn btn-danger">Back on main</a>
	</div>
</body>
</html>
