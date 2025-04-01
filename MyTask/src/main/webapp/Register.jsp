<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student1Management System</title>
<link rel="stylesheet" href="Register.css">
</head>
<body>
	<div class="container">
		<h2>Student Management System</h2>
		<h2 class="msg">${msgl2}</h2>
		<h2 class="msg">${msgr1}</h2>
		<h2 class="msg">${msgd}</h2>
		<form action="register" method="post">

			<div class="form-group">
				<label for="name">Full Name</label> <input type="text" name="uname"
					id="name" placeholder="Enter your full name" required>
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="email" name="uemail"
					id="email" placeholder="Enter your email" required>
			</div>
			<div class="form-group">
				<label for="phone">Phone Number</label> <input type="tel"
					name="unum" id="phone" placeholder="Enter your phone number"
					required>
			</div>
			<div class="form-group">
				<label for="standard">Standard</label> <input type="text"
					name="ustd" id="standard" placeholder="Enter your standard"
					required>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input name="upwd"
					type="password" id="password" placeholder="Enter your password"
					required>
			</div>
			<button type="submit">Register</button>
		</form>
		<div class="login-link">
			<a href="Login.jsp"> Log in</a>
		</div>
	</div>
</body>
</html>
