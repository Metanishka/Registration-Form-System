<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<%
String msg = (String)request.getAttribute("msg");

if(msg != null){
%>

<h3 style="color:red; text-align:center;">
    <%= msg %>
</h3>

<%
}
%>
<style>
body{
    background: linear-gradient(to right, #74ebd5, #9face6);
    font-family: Arial, sans-serif;
}
</style>
</head>

<body>
	<center>
		<h1>REGISTRATION FORM</h1>
	</center>
	<br>
	<center>
	<form method="Post" action="Signupservlet">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="name" name="uname" required></td>
			</tr>
			<tr>
				<td>Create Password:</td>
				<td><input type="password" name="upass" required></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input type="password" name="cpass" required></td>
			</tr>
			<tr>
				<td>Email-Id:</td>
				<td><input type="email" name="uemailId" required></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><select name="ucountry">
						<option>India</option>
						<option>Pakistan</option>
						<option>Bangladesh</option>
						<option>Japan</option>
						<option>Canada</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>