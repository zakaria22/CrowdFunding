<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="">
<table>
	<tr>
		<th>Designation</th><th>Description</th><th>Budget</th>
		<th>Manqué</th><th>Categorie</th><th>admin</th><th>Photo</th>
	</tr>
	<c:forEach items="${projets}" var="proj">
		<tr>
			<td>${proj.designation}</td>
			<td>${proj.description}</td>
			<td>${proj.budget}</td>
			<td>${proj.needed}</td>
			<td>${proj.categorie.nomCategorie}</td>
			<td>${proj.user.userName}</td>
			
			<td><img src="photoProj?idproj=${proj.idProjet}"></td>
      		<td><a href="suppProj?idProj=${proj.idProjet}">Supp</a></td>
      		<td><a href="editProj?idProj=${proj.idProjet}">Edit</a></td>
			
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>