<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<a href="<%=request.getContextPath() %>/register">S'enregistrer</a>
<a href="<%=request.getContextPath() %>/allProjects">tous les projets</a>

<h1>
	list of all categories
</h1>


<div id="">
<table>
	<tr>
		<th>Nom</th><th>Description</th><th>Photo</th>
	</tr>
	<c:forEach items="${categories}" var="cat">
		<tr>
			<td>${cat.nomCategorie}</td>
			<td>${cat.description}</td>
			<td><img src="photoCat?idCat=${cat.idCategorie}"></td>
			
		</tr>
	</c:forEach>
</table>
</div></body>
</html>
