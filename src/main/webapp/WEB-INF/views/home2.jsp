<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Acceuil</title>
	
	<!-- core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">      
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
