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
	<div class="wrapper">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Driver menu page</h3>
			</div>

			<div class="panel-body">
				<a href="driverApp" class="btn btn-link">Show your application »</a>
			</div>
		</div>

		<h5>Change Bus condition status</h5>

		<form action="changeBusCondition" class="form">
			<select name="condition">
				<option selected value="OK">OK</option>
				<option value="REPAIR_NEEDED">REPAIR_NEEDED</option>
			</select>

			<button class="btn btn-lg btn-primary btn-block" type="submit" value="Change">Change</button>
			<!-- <input type="submit" value="Change" class="btn btn-success"> -->
		</form>
		<a href="logout" class="btn btn-danger">Logout</a>
	</div>
</body>
</html>
