<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Catalogue</title>
            <style>

body {
	background-color: Yellow;
}

html, body {
    width: 100%;
}
table {
    margin: 100px auto;
}
thead {color:green;}
tbody {color:blue;}
tfoot {color:red;}

table, th, td {
  border: 1px solid black;
  font-weight: bold;
  font-size: 20px;
}
th{
	height : 30%;
	width : 10%;
}

select {
    font-size: .9rem;
    padding: 5px 40px;
}

</style>
        </head>

        <body>

            <header>
            </header>
            <br>

            <div class="row">

                <div class="container">
                    <h3 class="text-center" style="text-align:center">List of products</h3>
                    <hr>
                    <br>
                    <select id="Categorie" onchange="myFunction()">
                        <option value="">All</option>
          				<c:forEach var="item" items="${categories}">
            				<option value="${item.getRefCat()}">${item.getCat()}</option>
          				</c:forEach>
                    </select>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Reference</th>
                                <th>titre</th>
                                <th>Photo</th>
                                <th>prix</th>
                                <th>Ajouter</th>
                            </tr>
                        </thead>
                        <tbody id="tbArticle">
                            <c:forEach var="article" items="${articles}">

                                <tr>
                                 <td style="display:none;"><c:out value="${article.getCategorie().getCat()}"></c:out></td>
                                    <td>
                                        <a href="./Details?id=<c:out value='${article.getCodeArticle()}' />"><c:out value="${article.getCodeArticle()}" /></a>
                                    </td>
                                    <td>
                                        <c:out value="${article.getDesignation()}" />
                                    </td>
                                    <td>
                                    	<center>
                                    		<img  width="70" height="70" src="${article.getPhoto()}" />
                                        </center>
                                    </td>
                                    <td>
                                        <c:out value="${article.getPrix()}" />
                                    </td>
                                   
                                    <td><a href="./AddPanier?id=<c:out value='${article.getCodeArticle()}' />">Ajouter</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                    <c:if test="${panier.size()>0}">
                    	<p><a href="./AjouterCommande">Ajouter Commande</a></p>
                    	<p><a href="./Panier">Visualiser Panier</a></p>
                    </c:if>
                </div>
            </div>

            <script>
                function myFunction() {

                    var dpValue = document.getElementById("Categorie").value;
                    var table = document.getElementById("tbArticle");
                    var rows = table.getElementsByTagName("tr");

                    for (let row of rows) {
                        var cells = row.getElementsByTagName("td");

                        var code = row.cells[0] || null;

                        if (!dpValue || dpValue.trim().localeCompare(code.textContent.trim()) === 0) {
                        	
                            row.style.display = "";
                        } else {
                            row.style.display = "none";
                        }

                    }

                }
            </script>

        </body>

        </html>