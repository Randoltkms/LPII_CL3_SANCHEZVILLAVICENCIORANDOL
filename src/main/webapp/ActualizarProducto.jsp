<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.TblProductocl3"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Producto</title>
</head>
<body bgcolor="#c5dec9">
<h1 align="center">Actualizar Producto</h1>
<form method="post" action="ControladorProducto">
<% 
String idProducto = (request.getAttribute("codigo") != null) ? request.getAttribute("codigo").toString() : "";
String nombre = (request.getAttribute("nombre") != null) ? request.getAttribute("nombre").toString() : "";
String descripcion = (request.getAttribute("venta") != null) ? request.getAttribute("venta").toString() : "";
String estado = (request.getAttribute("compra") != null) ? request.getAttribute("compra").toString() : "";
String precioCompra = (request.getAttribute("estado") != null) ? request.getAttribute("estado").toString() : "";
String precioVenta = (request.getAttribute("descripcion") != null) ? request.getAttribute("descripcion").toString() : "";
%>
<table align="center" border="2">

<input type="hidden" name="codigo" value="<%=idProducto%>">

<tr>
<td>Nombre</td>
<td>
<input type="text" name="nombre" value="<%=nombre%>">
</td>
</tr>
<tr>
<td>Descripción</td>
<td>
<input type="text" name="venta" value="<%=descripcion%>">
</td>
</tr>
<tr>
<td>Estado</td>
<td>
<input type="text" name="compra" value="<%=estado%>">
</td>
</tr>
<tr>
<td>Precio Compra</td>
<td>
<input type="text" name="estado" value="<%=precioCompra%>">
</td>
</tr>
<tr>
<td>Precio Venta</td>
<td>
<input type="text" name="descripcion" value="<%=precioVenta%>">
</td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="Actualizar Producto">
</td>
</tr>

</table>

</form>
</body>
</html>
