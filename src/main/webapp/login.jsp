<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            background-color: #0000FF; /* Fondo azul */
            color: #000000; /* Letras negras */
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: #FFFFFF; /* Fondo blanco para el formulario */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        .login-container h1 {
            margin-bottom: 20px;
        }
        .login-container .input-line-container {
            margin-bottom: 15px;
            text-align: left;
        }
        .login-container .input-line-container .name-input {
            display: block;
            margin-bottom: 5px;
        }
        .login-container .input-line {
            width: 100%;
            padding: 10px;
            border: 1px solid #cccccc;
            border-radius: 5px;
        }
        .login-container .button-login {
            background-color: #007BFF; /* Azul claro */
            color: #FFFFFF;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            margin-top: 10px;
        }
        .login-container .button-login:hover {
            background-color: #0056b3; /* Azul más oscuro */
        }
        .login-container .button-second {
            background-color: #6c757d; /* Gris */
            color: #FFFFFF;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            margin-top: 10px;
        }
        .login-container .button-second:hover {
            background-color: #5a6268; /* Gris más oscuro */
        }
        .error-message {
            color: #FF0000;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1 class="title">Iniciar Sesión</h1>
        <form method="post" action="LoginServle">
            <div class="input-line-container">
                <span class="name-input">Usuario</span>
                <input type="text" name="usuario" class="input-line" required>
            </div>
            <div class="input-line-container">
                <span class="name-input">Contraseña</span>
                <input type="password" name="contraseña" class="input-line" required>
            </div>
            <button class="button-login" type="submit">Login</button>
            <button class="button-second" onclick="window.location.href = 'RegistrarUsuario.jsp';" type="button">Registrarse</button>
        </form>
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
        <div class="error-message">
            <%= errorMessage %>
        </div>
        <%
            }
        %>
    </div>
</body>
</html>
