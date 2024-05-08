<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro casi completado</title>
</head>

<body>
    <form:form>
        <form:checkbox path="anime" label="" value="true" />
        <form:checkbox path="arte" label="" value="true" />
        <form:checkbox path="cocina" label="" value="true" />
        <form:checkbox path="deporte" label="" value="true" />
        <form:checkbox path="fiestas" label="" value="true" />
        <form:checkbox path="fumador" label="" value="true" />
        <form:checkbox path="hijos" label="" value="true" />
        <form:checkbox path="lectura" label="" value="true" />
        <form:checkbox path="lgtv" label="" value="true" />
        <form:checkbox path="mascotas" label="" value="true" />
        <form:checkbox path="musica" label="" value="true" />
        <form:checkbox path="películas" label="" value="true" />
        <form:checkbox path="series" label="" value="true" />
        <form:checkbox path="signo" label="" value="true" />
        <form:checkbox path="viajes" label="" value="true" />
        <form:checkbox path="videojuegos" label="" value="true" />
    </form:form>
</body>

</html>