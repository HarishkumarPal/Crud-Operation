<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Details.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Student Details</h1>
	

	<div class="container">
		
		<div class="details">
			<h2>Name:    ${name }</h2>
			

			<h2>Email:    ${uemail }</h2>
			

			<h2>Phone:    ${phone }</h2>
			

			<h2>Standard:    ${std }</h2>
			

			<h2>Password:    ${pwd }</h2>
			
		</div>


		<div class="action-links">
			<a href="Dashboard.jsp" class="action-link update">Go Back</a>
		</div>
	</div>
</body>
</html>