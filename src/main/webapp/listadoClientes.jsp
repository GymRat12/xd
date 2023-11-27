<%@page import="com.cibertec.model.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Clientes</title>
</head>
<body>

<h3>Listado de Clientes</h3>

<p><a href="insertaCliente.jsp">Nuevo</a></p>

	<table border="1">
		<thead>
			<tr>
			  <th>Id</th>
			  <th>Nombres</th>
			  <th>Apellidos</th>
			  <th>DNI</th>
			  <th>Dirección</th>
			  <th>Acciones</th>
			</tr>
		</thead>
		<tbody>
		  <%
		  List<Cliente> lista = (List<Cliente>) request.getAttribute("data");
		  if (!lista.isEmpty()) {
			  for(Cliente item:lista) {
		  %>
		  <tr>
		    <td><%= item.getId() %></td>
		    <td><%= item.getNombre() %></td>
		    <td><%= item.getApellidos() %></td>
		    <td><%= item.getDni() %></td>
		    <td><%= item.getDireccion() %></td>
		    <td colspan="2">
		      <a title="Actualizar" href="ClienteServlet?action=detalle&id=<%= item.getId()%>">Actualizar</a> 
		      <a title="Eliminar" href="ClienteServlet?action=eliminar&id=<%= item.getId()%>">Eliminar</a>
		    </td>
		  </tr>
		  <%
		   }
		  }
		  %>
		</tbody>
	</table>

</body>
</html>