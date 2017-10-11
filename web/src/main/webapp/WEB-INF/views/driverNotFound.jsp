<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Driver not found</title>
	<link rel="stylesheet" href="/recourses/bootstrap.min.css">
	<link rel="stylesheet" href="/recourses/bootstrap-theme.min.css">
	<link rel="stylesheet" href="/recourses/main.css">
</head>
<body>
	<div class="wrapper">
		<div class="alert alert-danger">
			Driver with that passport ID is not exist in database.
		</div>

		<a href="dispatcherMain" class="btn btn-danger">Back on main</a>
	</div>
</body>
</html>
