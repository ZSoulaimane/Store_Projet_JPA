<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

h2 {
  text-align: center;
}

h3 {
  text-align: center;
}

body {background-color: Yellow;}
</style>
</head>
<body>

<h3> Bonjour  ${Clients.prenom} Chez Albumis choisi entre ces deux</h3><br>

<P><HR NOSHADE></P>

<h2><a href="./Catalogue.jsp">Consulter le Catalogue</a></h2><br>
<h2><a href="">Suivre vos Commandes</a></h2><br>

<c:if test="${panier.size()>0}">
                    	
                    	<h2><a href="./Panier">Visualiser votre panier</a></h2>
                    	</c:if>


</body>
</html>