<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<div>
	${exception}
</div>

<div id="formCategorie">
	<f:form modelAttribute="categorie" action="saveCategorie" 
		method="post" enctype="multipart/form-data">
		<table>	
			<tr>
				<td>Nom Categorie</td>
				<td><f:input path="nomCategorie"/></td>
				<td><f:errors path="nomCategorie" cssClass="errors"></f:errors></td>
			</tr>	
			<tr>
				<td>Description</td>
				<td><f:textarea path="description"/></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Photo</td>
				<td>
					<c:if test="${categorie.idCategorie!=null}">
						<img src="photoCat?idCat=${categorie.idCategorie}">
					</c:if>
					<input type="file" name="file"/>
				</td>
			</tr>
			<tr>
				<td><input type="submit"  value="Save"/></td>
			</tr>
			<tr>
				<td><f:input type="hidden"  value="${categorie.idCategorie}" path="idCategorie"/></td>
			</tr>
			
		</table>
	</f:form>
</div>
﻿
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
      		<td><a href="suppCat?idCat=${cat.idCategorie}">Supp</a></td>
      		<td><a href="editCat?idCat=${cat.idCategorie}">Edit</a></td>
			
		</tr>
	</c:forEach>
</table>
</div>