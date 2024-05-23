<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Registro</title>
    
    <style>
         @import url("https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap");
        * {
        font-family: "Montserrat", sans-serif;
        }
        body {
            background-color: #f8f9fa;
        }

        .container{
            display: flex;
            height: 100vh;
            align-items: center;
        }

        .register-form {
            width: 300px;
            margin: 20px auto;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #28a745;
        }

        form label {
            font-weight: bold;
        }

        form input[type="text"],
        form input[type="password"],
        form input[type="email"]
        {
            width: 94%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ced4da;
            border-radius: 4px;
        }

        form button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-bottom: 20px;
        }

        form a {
            display: block;
            text-align: center;
            margin-top: 10px;
            color: #28a745;
        }

        body{
            background: linear-gradient(#36c95852, #ebf8e16d, #21883918);
        }
    </style>
</head>

<body>
    <div class="container">
    <div class="register-form ">
        <h1>Registro:</h1>
        <form:form modelAttribute="usuario" action="/registro" method="POST" >

            <form:label path="nombre" for="nombre">
                Nombre:
            </form:label>
            <form:input path="nombre" id="nombre" name="nombre" type="text"></form:input>
            <form:errors path="nombre"></form:errors>
            <br>

            <form:label path="correo" for="correo">
                Correo:
            </form:label>
            <form:input path="correo" id="correo" name="correo" type="email"></form:input>
            <form:errors path="correo"></form:errors>
            <br>

            <form:label path="contrasena" for="contrasena">
                Contraseña:
            </form:label>
            <form:input path="contrasena" id="contrasena" name="contrasena" type="password"></form:input>
            <form:errors path="contrasena"></form:errors>
            <br>

            <form:label path="confirmacionContrasena" for="confirmacionContrasena">
                Confirmar Contraseña:
            </form:label>
            <form:input path="confirmacionContrasena" id="confirmacionContrasena" name="confirmacionContrasena"
                type="password"></form:input>
            <form:errors path="confirmacionContrasena"></form:errors>
            <br>
            <a href="/login">¿Ya tienes una cuenta?, Inicia sesión</a>
            <br>
            <button>Registro</button>
        </form:form>
    </div>
    </div>
</body>

</html>
