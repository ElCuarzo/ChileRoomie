<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
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
                padding: 10px;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
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
                width: 96%;
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
        <div class="register-form">
        <h1>Login:</h1>
	    <form:form modelAttribute="usuarioLogin" action="/login" method="POST">
            <form:label path="correoLogin" for="correoLogin">
                Correo:
            </form:label>
            <form:input path="correoLogin" id="correoLogin" name="correoLogin" type="text"></form:input>
            <form:errors path="correoLogin"></form:errors>
            <br>
            <form:label path="contrasenaLogin" for="contrasenaLogin">
                Contraseña:
            </form:label>
            <form:input path="contrasenaLogin" id="contrasenaLogin" name="contrasenaLogin" type="password"></form:input>
            <form:errors path="contrasenaLogin"></form:errors>
            <br>
            <a href="/registro">¿No tienes una cuenta?, Registrate</a>
            <br>
            <button>Login</button>
	    </form:form>
        </div>
        </div>
    </body>
</html>