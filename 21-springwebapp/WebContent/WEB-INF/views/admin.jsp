<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin.jsp</title>
</head>
<body>
	<h1>admin.jsp</h1>
	<sf:form action="${pageContext.request.contextPath}/admin/save" method="post" commandName="admin">
		<table>
			<tr>
				<td>Estado particular</td>
				<td><input name="estado" type="text" /></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><sf:input path="nombre" type="text" /></td>
			</tr>
			<tr>
				<td>Cargo</td>
				<td><sf:input path="cargo" type="text" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Guardar cambios"/></td>
			</tr>
		</table>
	</sf:form>
	<c:out value="${resultado}"/>
</body>
</html>