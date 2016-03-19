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
	<div id="ajouterCategorie">
		<f:form modelAttribute="categorie" action="saveCategorie" 
								method="post" enctype="multipart/form-data">
			<div>
				<div>
					<f:label path="nomCategorie">Nom : </f:label>
					<f:input path="nomCategorie"></f:input>
					<f:errors path="nomCategorie" cssClass="errors"></f:errors>
				</div>
				<div>
					<f:label path="description" >Description :</f:label>
					<f:textarea path="description"></f:textarea>
					<f:errors path="description" cssClass="errors"></f:errors>
				</div>
				<div>
					<f:label path="photo" >photo :</f:label>
					<input type="file" name="file" />
				</div>
			</div>
			<div>
				<input type="submit" value="Save">
			</div>		
		</f:form>
	</div>

	<div id="listerCategorie">
		<table>
			<tr>
				<th>ID</th>
				<th>Nom Cat</th>
				<th>Description</th>
				<th>Photo</th>
			</tr>
			<c:forEach items="${categories}" var="categ">
				<tr>
					<td>${categ.idCategorie}</td>
					<td>${categ.nomCategorie}</td>
					<td>${categ.description}</td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
	</div>	
	
</body>
</html>