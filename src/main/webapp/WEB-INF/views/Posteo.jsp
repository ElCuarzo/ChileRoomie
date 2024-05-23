<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Posteo</title>
    <link rel="stylesheet" href="/css/Posteo.css">
</head>
<body>
    <header>
        <div class="logo">
            <a href="/">
                <img
                    src="/images/rommie-app-logo-original.png"
                    alt="Logo ChileRoomie"
                    style="display: block"
                />
            </a>
        </div>
        <div class="login">
            <a href="/logout"><button>Cerrar sesion</button></a>
        </div>
    </header>
      <h1>Crea un Post</h1>
      <main>
    <form:form action="/procesar/posteo" method="post" modelAttribute="formularioCrear" enctype="multipart/form-data">

        <!-- Datos del Arriendo -->
        <fieldset>
            <legend>Información Del Arriendo</legend>
            <p>¿Está Amoblado?</p>
            <form:radiobutton path="arriendoAct.amoblado" value="true" /> <p>Si</p>
            <form:radiobutton path="arriendoAct.amoblado" value="false" /> <p>No</p>
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
            <div class="caracteristicas">
            <div class="caracteristicas-check">
                <div class="caracteristica-check">
                    <form:checkbox path="caracteristicaAct.accesoGas" label="¿Cuenta con servicio Gas?" value="true"/>
                </div>
                <div class="caracteristica-check">
                    <form:checkbox path="caracteristicaAct.internet" label="¿Cuenta con Internet?" value="true"/>
                </div>
                <div class="caracteristica-check">
                    <form:checkbox path="caracteristicaAct.mesaPool" label="¿Cuenta con Mesa de Pool?" value="true"/>
                </div>
                <div class="caracteristica-check">
                    <form:checkbox path="caracteristicaAct.gimnasio" label="¿Cuenta con Gimnasio?" value="true"/>
                </div>
                <div class="caracteristica-check">
                    <form:checkbox path="caracteristicaAct.quincho" label="¿Cuenta con Quincho?" value="true"/>
                </div>
                <div class="caracteristica-check">
                    <form:checkbox path="caracteristicaAct.mascotas" label="¿Acepta Mascotas?" value="true"/>
                </div>
                <div class="caracteristica-check">
                    <form:checkbox path="caracteristicaAct.estacionamiento" label="¿Cuenta con estacionamiento?" value="true"/>
                </div>
                <form:errors path="caracteristicaAct" cssClass="error" />
            </div>
            <br>
            
            <div class="caracteristicas-check">
                <div class="caracteristica-check">
                    <form:label path="caracteristicaAct.habitaciones">Número de habitaciones:</form:label>
                    <form:input path="caracteristicaAct.habitaciones" type="number" min="0" required="true"/>
                    <form:errors path="caracteristicaAct.habitaciones" cssClass="error" />
                </div>
                
                <div class="caracteristica-check">
                <form:label path="caracteristicaAct.baños">Número de baños:</form:label>
                <form:input path="caracteristicaAct.baños" type="number" min="0" required="true"/>
                <form:errors path="caracteristicaAct.baños" cssClass="error" />
            </div>
            
            <div class="caracteristica-check">
                <form:label path="caracteristicaAct.gastosComunes">Gastos Comunes:</form:label>
                <form:input path="caracteristicaAct.gastosComunes" type="number" min="0"/>
                <form:errors path="caracteristicaAct.gastosComunes" cssClass="error" />
            </div>
            
            <div class="caracteristica-check">
                <form:label path="caracteristicaAct.descripcion">Descripción:</form:label>
                <form:input path="caracteristicaAct.descripcion" required="true"/>
                <form:errors path="caracteristicaAct.descripcion" cssClass="error" />
            </div>
            </div>
        </div>
        </fieldset>
        
    </form:form>
    <div class="save-button">
        <a href="/"><button class="cancel">Cancelar</button></a>
        <a href="/"><button type="submit">Guardar</button></a>
    </div>
</main>
</body>
</html>
