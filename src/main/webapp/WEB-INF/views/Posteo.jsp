<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Posteo</title>
</head>
<body>
    <h1>Vista Posteo</h1>
    <form:form action="/procesar/posteo" method="post" modelAttribute="formularioCrear" enctype="multipart/form-data">

        <!-- Datos del Arriendo -->
        <fieldset>
            <legend>Información Del Arriendo</legend>
            <p>¿Está Amoblado?</p>
            Si <form:radiobutton path="arriendoAct.amoblado" value="true" />
            No <form:radiobutton path="arriendoAct.amoblado" value="false" />
            <form:errors path="arriendoAct.amoblado" cssClass="error" />

            <br>
            <form:label path="arriendoAct.precio">Precio:</form:label>
            <form:input path="arriendoAct.precio" type="number" min="0" required="true" />
            <form:errors path="arriendoAct.precio" cssClass="error" />

            <br>
            <form:label path="arriendoAct.domicilio">Selecione el tipo de domicilio</form:label>
            <form:select path="arriendoAct.domicilio" required="true">
                <form:option path="arriendoAct.domicilio" value="Casa">Casa</form:option>
                <form:option path="arriendoAct.domicilio" value="Departamento">Departamento</form:option>
                <form:option path="arriendoAct.domicilio" value="Pension">Pension</form:option>
            </form:select>
            <br>
            <label for="imagen">Imagen</label>
            <input type="file" name="file" accept=".jpg, .png">
            <p>Solo imagenes con formato JPG y PNG (de hasta 10MB)</p>
        </fieldset>

        <!-- Datos de la dirección -->
        <fieldset>
            <legend>Dirección Del Arriendo</legend>
            <form:label path="direccionAct.direccion">Dirección:</form:label>
            <form:input path="direccionAct.direccion" required="true" />

            <form:label path="direccionAct.ciudad">Ciudad:</form:label>
            <form:input path="direccionAct.ciudad" required="true" />

            <form:label path="direccionAct.comuna">Comuna:</form:label>
            <form:input path="direccionAct.comuna" required="true" />
        </fieldset>

        <!-- Datos de las características -->
        <fieldset>
            <legend>Características Del Arriendo</legend>
            <form:checkbox path="caracteristicaAct.accesoGas" label="¿Cuenta con servicio Gas?" value="true"/>
            <form:checkbox path="caracteristicaAct.internet" label="¿Cuenta con Internet?" value="true"/>
            <form:checkbox path="caracteristicaAct.mesaPool" label="¿Cuenta con Mesa de Pool?" value="true"/>
            <form:checkbox path="caracteristicaAct.gimnasio" label="¿Cuenta con Gimnasio?" value="true"/>
            <form:checkbox path="caracteristicaAct.quincho" label="¿Cuenta con Quincho?" value="true"/>
            <form:checkbox path="caracteristicaAct.mascotas" label="¿Acepta Mascotas?" value="true"/>
            <form:checkbox path="caracteristicaAct.estacionamiento" label="¿Cuenta con estacionamiento?" value="true"/>
            <form:errors path="caracteristicaAct" cssClass="error" />
            <br>
            <form:label path="caracteristicaAct.habitaciones">Número de habitaciones:</form:label>
            <form:input path="caracteristicaAct.habitaciones" type="number" min="0" required="true"/>
            <form:errors path="caracteristicaAct.habitaciones" cssClass="error" />

            <form:label path="caracteristicaAct.baños">Número de baños:</form:label>
            <form:input path="caracteristicaAct.baños" type="number" min="0" required="true"/>
            <form:errors path="caracteristicaAct.baños" cssClass="error" />

            <form:label path="caracteristicaAct.gastosComunes">Gastos Comunes:</form:label>
            <form:input path="caracteristicaAct.gastosComunes" type="number" min="0"/>
            <form:errors path="caracteristicaAct.gastosComunes" cssClass="error" />

            <form:label path="caracteristicaAct.descripcion">Descripción:</form:label>
            <form:input path="caracteristicaAct.descripcion" required="true"/>
            <form:errors path="caracteristicaAct.descripcion" cssClass="error" />
        </fieldset>

        <button type="submit">Guardar</button>
    </form:form>
</body>
</html>
