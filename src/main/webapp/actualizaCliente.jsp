<%@page import="com.cibertec.model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Cliente</title>
</head>
<body>

	<h3>Actualización de Clientes</h3>
    <%
       Cliente cliente = (Cliente) request.getAttribute("objeto");
    %>
	<form action="ClienteServlet" method="post">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="txtNombre" value="<%= cliente.getNombre() %>" /></td>
			</tr>
			<tr>
				<td>Apellidos:</td>
				<td><input type="text" name="txtApellidos" value="<%= cliente.getApellidos() %>" /></td>
			</tr>
			<tr>
				<td>DNI:</td>
				<td><input type="text" name="txtDni" value="<%= cliente.getDni() %>" /></td>
			</tr>
			<tr>
				<td>Dirección:</td>
				<td><input type="text" name="txtDireccion" value="<%= cliente.getDireccion() %>" /></td>
			</tr>
			<tr>

				<td colspan="2">
				  <input type="hidden" value="<%= cliente.getId() %>" name="txtId" />
				  <input type="hidden" value="actualizar" name="action" /> 
				  <input type="submit" value="Enviar Datos" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>