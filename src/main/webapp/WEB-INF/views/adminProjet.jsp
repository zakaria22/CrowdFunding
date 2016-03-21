<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<div class="errors">
	${exception}
</div>

<div id="formProjet">
	<f:form modelAttribute="projet" action="saveProjet" 
		method="post" enctype="multipart/form-data">
		<table>	
			<tr>
				<td>Nom Projet</td>
				<td><f:input path="designation"/></td>
				<td><f:errors path="designation" cssClass="errors"></f:errors></td>
			</tr>	
			<tr>
				<td>Description</td>
				<td><f:textarea path="description"/></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Budget</td>
				<td><f:input path="budget"/></td>
				<td><f:errors path="budget" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Manqué</td>
				<td><f:input path="needed"/></td>
				<td><f:errors path="needed" cssClass="errors"></f:errors></td>
			</tr>
	
			<tr>
				<td>Categorie</td>
				<td><f:select path="categorie.idCategorie" items="${categories }" itemValue="idCategorie" itemLabel="nomCategorie"/></td>
				<td><f:errors path="categorie.idCategorie" cssClass="errors"></f:errors></td>
			</tr>	
			<tr>
				<td>admin</td>
				<td><f:input path="user.idUser"/></td>
				<td><f:errors path="user.idUser" cssClass="errors"></f:errors></td>
			</tr>	
			<tr>
				<td>Photo</td>
				<td>
					<c:if test="${projet.idProjet!=null}">
						<img src="photoProj?idproj=${projet.idProjet}">
					</c:if>
					<input type="file" name="file"/>
				</td>
			</tr>
			<tr>
				<td><input type="submit"  value="Save"/></td>
			</tr>
			<tr>
				<td><f:input type="hidden"  value="${projet.idProjet}" path="idProjet"/></td>
			</tr>
		</table>
	</f:form>
</div>
﻿
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