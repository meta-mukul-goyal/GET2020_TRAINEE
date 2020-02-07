<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="cssfile.css" />
</head>
<body>

<form id="registerformid" action="loginservlet" method="post">
<fieldset>
		<h1>Login Form</h1>
		<input id="email" type="email" placeholder="email" name="empemail" required><br><br> 
		<input id="password" type="password" placeholder="password" name="emppassword"required><br> <br> 
		<input type="submit" value="login" >
</fieldset>
</form>
</body>
</html>