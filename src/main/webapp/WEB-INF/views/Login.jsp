<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <style>
            body {
                background-color: #f8f9fa;
            }
    
            .container{
                display: flex;
                height: 100vh;
                align-items: center;
            }
    
            .register-form {
                max-width: 500px;
                margin: 20px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);    
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
                width: 100%;
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
            }
    
            form a {
                display: block;
                text-align: center;
                margin-top: 10px;
                color: #28a745;
            }
    
            body{
                background-image: url("https://r4.wallpaperflare.com/wallpaper/135/559/641/video-game-fortnite-hd-wallpaper-b8469d88f0006c98c0eca10e2802047a.jpg"); /* The image used */
                background-size: cover; /* Cover the entire background */
                background-position: center; /* Center the background */
                background-attachment: fixed; /* Keep the background fixed while scrolling */
            }
        </style>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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