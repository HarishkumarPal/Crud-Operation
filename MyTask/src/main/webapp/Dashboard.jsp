<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dashboard - Student Management System</title>
<link rel="stylesheet" href="Dashboard.css">
</head>
<body>

	<div class="container">
		<h1>Dashboard</h1>
		<h3>${msgu }</h3>
		<div class="dashboard-content">
			<%
			session.getAttribute("name");
			String email=(String)session.getAttribute("email");
			email.trim();
			
			%>
			<h2>
				Welcome,
				<%-- <%=name %> --%>${name }!
			</h2>


			<div class="action-links">

				<a href="update?email= <%=email%>" class="action-link update">Update</a>
				<a href="details?email=<%=email%>" class="action-link details">Details</a>
				<a href="delete?email=<%=email%>" class="action-link delete">Delete</a>
			</div>
		</div>
	</div>
</body>
</html>
