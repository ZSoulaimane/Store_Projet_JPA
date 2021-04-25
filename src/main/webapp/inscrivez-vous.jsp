<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registering Form</title>

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

<form action="<%= request.getContextPath() %>/Register" method="post">
			<table style="with: 50%">
				<tr>
					<td>Prenom</td>
					<td><input type="text" name="first_name" size="36" required/></td>
				</tr>
				<tr>
					<td>Nom</td>
					<td><input type="text" name="last_name" size="36" required /></td>
				</tr>
				<tr>
					<td>Adresse</td>
					<td><input type="text" name="Adresse" /><br>
					<input type="number" name="CodePostal" size="10"/><input type="text" name="Ville" size="20" required/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="Email" size="36" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required /></td>
				</tr>
				<tr>
					<td>Tel</td>
					<td><input type="number" name="Tel" size="36" required/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" size="36" required/></td>
				</tr>

			</table>
			<input type="submit" value="Submit" size="50" id="hello"/>
			</form>

</body>
</html>