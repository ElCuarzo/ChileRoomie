<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Registro</title>
</head>
<body>
    <h1>Registro:</h1>
    <form:form modelAttribute="usuario" action="/registro" method="POST">

        <form:label path="nombre" for="nombre">
            Nombre:
        </form:label>
        <form:input path="nombre" id="nombre" name="nombre" type="text"></form:input>
        <form:errors path="nombre"></form:errors>
        <br>

        <form:label path="correo" for="correo">
            Correo:
        </form:label>
        <form:input path="correo" id="correo" name="correo" type="text"></form:input>
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