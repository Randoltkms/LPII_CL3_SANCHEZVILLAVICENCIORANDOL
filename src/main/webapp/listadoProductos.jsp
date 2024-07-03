<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.*" %>
    <%@page import="model.TblProductocl3" %>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
 
  
    
<!DOCTYPE htm>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Clientes</title>
</head>
<body bgcolor="#c5dec9">
<h1  align="center">Listado de Producto Registrados en BD</h1>

<h2 align="center">
<a href="RegistrarProducto.jsp" style="text-decoration: none;color:blue;">Registrar Producto</a>
</h2>
<table border="2" align="center">

<tr>
<td>Codigo</td>
<td>Nombre</td>
<td>Precio de venta</td>
<td>Precio de compra</td>
<td>Estado de Compra</td>
<td>Describe</td>

<td colspan="2" align="center">Acciones</td>
</tr>

<%
List<TblProductocl3> ListadoProducto=(List<TblProductocl3>)request.getAttribute("listadoproductos");
//aplicamos una condicion..
if(ListadoProducto!=null){
	//aplicamos un bucle for..
	for(TblProductocl3 lis:ListadoProducto){
		%>
		<tr>
		<td><%=lis.getIdproductoscl3()%></td>
		<td><%=lis.getNombrecl3() %></td>
		<td><%=lis.getPrecioventacl3() %></td>
		<td><%=lis.getPreciocompcl3() %></td>
		<td><%=lis.getEstadocl3() %></td>
		<td><%=lis.getDescripcl3() %></td>
		
	
	    <td><a href="ControladorProducto?accion=Modificar&cod=<%=lis.getIdproductoscl3()%>">Actualizar</a></td>
	     <td><a href="ControladorProducto?accion=Eliminar&cod=<%=lis.getIdproductoscl3()%>">Eliminar</a></td>
		
		</tr>
		
		
	<%	
	}   //fin del bucle for...
	%>
	<%
}  //fin de la condicion ...

%>
</table>
</body>
</html>