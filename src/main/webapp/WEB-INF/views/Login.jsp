<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        
    </head>
    <body>
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
        
    </body>
</html>