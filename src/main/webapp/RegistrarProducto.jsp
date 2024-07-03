<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Productos</title>
<style type="text/css">
    body {
        background-color: #87CEFA; /* Fondo azul claro */
        font-family: Arial, sans-serif; /* Tipo de fuente para el cuerpo del documento */
        padding: 20px; /* Espaciado interior */
        margin: 0; /* Eliminar margen exterior */
        color: black; /* Color de texto negro para todo el documento */
    }
    .titulo {
        text-align: center;
        color: black; /* Color de texto negro */
    }
    .formulario-productos {
        background-color: white; /* Fondo blanco */
        border-radius: 10px; /* Bordes redondeados */
        padding: 20px; /* Espaciado interno */
        width: 50%; /* Ancho del formulario */
        margin: 50px auto; /* Margen superior de 50px y centrado horizontalmente */
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Sombra ligera alrededor del formulario */
    }
    .formulario-productos table {
        width: 100%; /* Ancho completo de la tabla */
    }
    .formulario-productos th, .formulario-productos td {
        padding: 10px; /* Espaciado interno de celda */
        text-align: left; /* Alineación del texto a la izquierda */
        color: black; /* Color de texto negro */
        font-size: 16px; /* Tamaño de fuente */
    }
    .formulario-productos th {
        background-color: #f2f2f2; /* Fondo gris claro para encabezados */
    }
    .formulario-productos input[type="text"] {
        width: 95%; /* Ancho casi completo del campo de entrada */
        padding: 8px; /* Espaciado interno del campo de entrada */
        margin: 5px 0; /* Margen superior e inferior */
        box-sizing: border-box; /* Incluir el padding en el ancho total */
        border: 1px solid #ccc; /* Borde gris claro */
        border-radius: 4px; /* Bordes redondeados */
        text-align: left; /* Alinear texto a la izquierda */
    }
    .formulario-productos input[type="submit"] {
        background-color: #1E90FF; /* Botón azul */
        color: white; /* Texto blanco */
        border: none; /* Sin borde */
        border-radius: 20px; /* Bordes redondeados */
        padding: 15px 30px; /* Espaciado interno */
        font-size: 18px; /* Tamaño de fuente */
        cursor: pointer; /* Cambio de cursor */
        display: block; /* Hace que el botón ocupe toda la anchura disponible */
        margin: 20px auto; /* Margen superior e inferior de 20px, centrado horizontalmente */
        text-align: center; /* Alineación centrada del texto */
        text-decoration: none; /* Sin subrayado */
    }
    .formulario-productos input[type="submit"]:hover {
        background-color: #104E8B; /* Color de fondo más oscuro en hover */
    }
</style>
</head>
<body>

<h1 class="titulo">REGISTRAR PRODUCTOS</h1>

<div class="formulario-productos">
    <form action="ControladorProducto" method="post">

        <table>
            <tr>
                <th>NOMBRE</th>
                <td><input type="text" name="nombre" required></td>
            </tr>
            <tr>
                <th>P. VENTA</th>
                <td><input type="text" name="venta" required></td>
            </tr>
            <tr>
                <th>P. COMPRA</th>
                <td><input type="text" name="compra" required></td>
            </tr>
            <tr>
                <th>ESTADO</th>
                <td><input type="text" name="estado" required></td>
            </tr>
            <tr>
                <th>DESCRIPCION</th>
                <td><input type="text" name="descripcion" required></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Registrar Producto">
                </td>
            </tr>
        </table>

    </form>
</div>

</body>
</html>
