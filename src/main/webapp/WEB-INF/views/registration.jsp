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
<div id="registration">
	<f:form modelAttribute="user" action="saveUser" 
		method="post" >
		<table>	
			<tr>
				<td>Nom </td>
				<td><f:input path="userName"/></td>
				<td><f:errors path="userName" cssClass="errors"></f:errors></td>
			</tr>	
			<tr>
				<td>adresse</td>
				<td><f:textarea path="adresse"/></td>
				<td><f:errors path="adresse" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>telephone</td>
				<td><f:input path="tel"/></td>
				<td><f:errors path="tel" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>email</td>
				<td><f:input path="email"/></td>
				<td><f:errors path="email" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>password</td>
				<td><f:password path="password" /></td>
				<td><f:errors path="password" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td><input type="submit"  value="Save"/></td>
			</tr>
		</table>
	</f:form>
</div>


</body>
</html>