<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Prodcuctos</title>
</head>
<body>

	<h3>Registro de Productos</h3>

	<form action="ClienteServlet" method="post">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="txtNombre" /></td>
			</tr>
			<tr>
				<td>Apellidos:</td>
				<td><input type="text" name="txtApellidos" /></td>
			</tr>
			<tr>
				<td>DNI:</td>
				<td><input type="text" name="txtDni" /></td>
			</tr>
			<tr>
				<td>Dirección:</td>
				<td><input type="text" name="txtDireccion" /></td>
			</tr>
			<tr>

				<td colspan="2"><input type="hidden" value="registrar"
					name="action" /> <input type="submit" value="Enviar Datos" /></td>
			</tr>
		</table>
	</form>
</body>
</html>