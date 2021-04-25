<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
<style>

h2 {
  text-align: center;
}

h3 {
  text-align: center;
}
body {
	background-color: Yellow;
}

input {
    margin:0 10px 5px 0;
}

html, body {
    width: 100%;
}
table {
    margin: 100px auto;
}
table, tr, td {
  border: 1px solid black;
  font-size: 20px;
}
th{
	height : 30%;
	width : 10%;
}
#hello{
  display: block;
  margin-right: auto;
  margin-left: auto;
  width: 20em;  height: 2em;
}


</style>
</head>
<body>
<form action="<%= request.getContextPath() %>/login" method="post">
		<table style="with: 50%">
 
			<tr>
				<td>Email</td>
				<td><input type="text" name="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required/></td>
			</tr>
		</table>
		<input type="submit" value="Login" id="hello"/></form>
</body>
</html>