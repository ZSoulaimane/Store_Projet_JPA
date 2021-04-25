<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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


<title>Insert title here</title>
</head>
<body>

<table>
   <tr>
   		<th>Reference</th>
        <th>titre</th>
        <th>Photo</th>
        <th>prix</th>
        <th>Stock</th>
   </tr>
  <tr>
    <td>${arr.getCodeArticle()}</td>
    <td>${arr.getDesignation()}</td>
    <td>
    <center>
 	<img  width="70" height="70" src="${arr.getPhoto()}" /></center></td>
    <td>${arr.getPrix()}</td>
    <td>${arr.getStock()}</td>
  </tr>
</table>

<p><a href="./Catalogue.jsp">Retour</a></p>

</body>
</html>
