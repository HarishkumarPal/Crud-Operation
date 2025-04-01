<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Management System - Update</title>
<link rel="stylesheet" href="Update.css">
</head>
<body>


	<div class="container">
		<h2>Update Student Information</h2>
		<form action="change" method="post">

			<%
			String name = (String) request.getAttribute("name");
			String email = (String) request.getAttribute("uemail");
			long phone = (long) request.getAttribute("phone");
			String std = (String) request.getAttribute("std");
			String pwd = (String) request.getAttribute("pwd");
			%>
			<div class="form-group">
				<label for="name">Full Name</label> <input type="text" name="uname"
					id="name" placeholder="Enter your full name" required
					value=<%=name%>>
			</div>

			<div class="form-group">
				<label for="email">Email</label>
				<h5>This Field is not Editable</h5>
				<input type="email" name="uemail" id="email" value=<%=email%>
					placeholder="Enter your email" required readonly="readonly">
			</div>
			<div class="form-group">
				<label for="phone">Phone Number</label> <input type="tel"
					name="unum" id="phone" value=<%=phone%>
					placeholder=" Enter your phone number" required>
			</div>
			<div class="form-group">
				<label for="standard">Standard</label> <input type="text"
					name="ustd" id="standard" placeholder="Enter your standard"
					value=<%=std%>>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input name="upwd"
					type="text" id="password" placeholder=" Enter your password"
					required value=<%=pwd%>>
			</div>
			<button type="submit">Update</button>
		</form>
		<div class="back-to-dashboard">
			<a href="Dashboard.jsp">Go Back</a>
		</div>
	</div>
</body>
</html>
