<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login - Student Management System</title>
<link rel="stylesheet" href="Login.css">
</head>
<body>
	<div class="container">

		<h2>Login Form</h2>
		<h2>${msgl1}</h2>
		<h2>${msg1}</h2>
		<h2>${msgr}</h2>
		<h2>${msgr1}</h2>
		<form action="login" method="post">

			<div class="form-group">
				<label for="email">Email</label> <input name="uemail" type="email"
					id="email" placeholder="Enter your email" required>
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input name="upass"
					type="password" id="password" placeholder="Enter your password"
					required>
			</div>
			<button type="submit">Login</button>
		</form>
		<div class="register-link">
			<p>
				<a href="Register.jsp">Register here</a>
			</p>
		</div>
	</div>
</body>
</html>
