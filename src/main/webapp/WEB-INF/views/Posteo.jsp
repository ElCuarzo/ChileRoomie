<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Posteo</title>
</head>
<body>
    <h1>Vista Posteo</h1>
    <form:form action="/procesar/posteo" method="post" modelAttribute="arriendo">

        <!-- Datos del Arriendo -->

        <fieldset>
            <legend>Información Del Arriendo</legend>
            <p>¿Está Amoblado?</p>
                Si <form:radiobutton path="amoblado" value="true" />
                No <form:radiobutton path="amoblado" value="false" />

            <form:label path="precio">Precio:</form:label>
            <form:input path="precio" type="number" min="0" required="true" />
        </fieldset>

        <!-- Datos de la dirección -->

        <fieldset>
            <legend>Dirección Del Arriendo</legend>
            <form:label path="direccion.direccion">Dirección:</form:label>
            <form:input path="direccion.direccion" required="true" />

            <form:label path="direccion.ciudad">Ciudad:</form:label>
            <form:input path="direccion.ciudad" required="true" />

            <form:label path="direccion.comuna">Comuna:</form:label>
            <form:input path="direccion.comuna" required="true" />
        </fieldset>

        <!-- Datos de las características -->

        <fieldset>
            <legend>Características Del Arriendo</legend>
            <form:checkbox path="caracteristica.accesoGas" label="¿Cuenta con servicio Gas?" value="true"/>
            <form:checkbox path="caracteristica.internet" label="¿Cuenta con Internet?"/>
            <form:checkbox path="caracteristica.mesaPool" label="¿Cuenta con Mesa de Pool?"/>
            <form:checkbox path="caracteristica.gimnasio" label="¿Cuenta con Gimnasio?"/>
            <form:checkbox path="caracteristica.quincho" label="¿Cuenta con Quincho?"/>
            <form:checkbox path="caracteristica.mascotas" label="¿Acepta Mascotas?"/>
            <form:checkbox path="caracteristica.estacionamiento" label="¿Cuenta con estacionamiento?"/>

            <form:label path="caracteristica.habitaciones">Número de habitaciones:</form:label>
            <form:input path="caracteristica.habitaciones" type="number" min="0" required="true"/>

            <form:label path="caracteristica.baños">Número de baños:</form:label>
            <form:input path="caracteristica.baños" type="number" min="0" required="true"/>

            <form:label path="caracteristica.gastosComunes">Gastos Comunes:</form:label>
            <form:input path="caracteristica.gastosComunes" type="number" min="0"/>

            <form:label path="caracteristica.descripcion">Descripción:</form:label>
            <form:input path="caracteristica.descripcion" required="true"/>
        </fieldset>

        <button type="submit">Guardar</button>
    </form:form>
</body>
</html>
