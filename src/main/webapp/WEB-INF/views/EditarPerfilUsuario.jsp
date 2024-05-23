<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar perfil usuario</title>
    <link rel="stylesheet" href="/css/EditarPerfilUsuario.css">
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
    <main>
    <form:form action="/perfil/editar/${usuario.id}" method="post" modelAttribute="formularioUsuario" enctype="multipart/form-data">
        <!-- Información de usuario -->
        <fieldset>
          <legend>Información de usuario</legend>

          <div class="main-information">
            <form:label path="usuarioAct.nombre">Nombre: </form:label>
            <form:input type="text" path="usuarioAct.nombre"/>

            <form:label path="usuarioAct.apellido">Apellido: </form:label>
            <form:input type="text" path="usuarioAct.apellido"/>

            <form:label path="usuarioAct.edad">Edad: </form:label>
            <form:input type="number" path="usuarioAct.edad" min="18" max="27"/>
          </div> 
          <div class="genero">
            <p>¿Con que genero te identificas?</p>
              Masculino:<form:radiobutton path="usuarioAct.genero" value="He"/>
              Femenino:<form:radiobutton path="usuarioAct.genero" value="She"/>
              No especificar:<form:radiobutton path="usuarioAct.genero" value=""/>
          </div>
          <br>
          <label for="imagen">Imagen</label>
            <input type="file" name="file" accept=".jpg, .png">
            <p>Solo imagenes con formato JPG y PNG (de hasta 10MB)</p>
          
          <br>
          <form:label path="usuarioAct.telefono">Indique su numero de telefono</form:label>
          <form:input type="text" path="usuarioAct.telefono" required="true" max="18" min="9"></form:input>

          <br>
          <form:label path="usuarioAct.universidad">Seleccione su Universidad</form:label>
          <form:select path="usuarioAct.universidad" required="true">
            <form:option path="usuarioAct.universidad" label="UBB" value="Universidad del Bio-Bio"></form:option>
            <form:option path="usuarioAct.universidad" label="UdeC" value="Universidad de Concepción"></form:option>
            <form:option path="usuarioAct.universidad" label="Virginio Goméz" value="Virginio Goméz"></form:option>
            <form:option path="usuarioAct.universidad" label="Inacap" value="Inacap"></form:option>
            <form:option path="usuarioAct.universidad" label="Santo Tomás" value="Santo Tomás"></form:option>
            <form:option path="usuarioAct.universidad" label="USS" value="Universidad San Sebastian"></form:option>
            <form:option path="usuarioAct.universidad" label="UDD" value="Universidad del Desarrollo"></form:option>
            <form:option path="usuarioAct.universidad" label="UCSC" value="Universidad Catolica de la Santísima Concepción"></form:option>
            <form:option path="usuarioAct.universidad" label="UNAB" value="Universidad Andrés Bello"></form:option>
            <form:option path="usuarioAct.universidad" label="UTFSM" value="Universidad Técnica Federico Santa maria"></form:option>
            <form:option path="usuarioAct.universidad" label="DuocUC" value="Duoc UC"></form:option>
          </form:select>
        </fieldset>

        <!-- Tabla de gustos del usuario -->
        <fieldset>
            <legend>Información gustos usuario</legend>
            <form:checkbox path="gustosAct.anime" label=" Anime" value="true" />
            <form:checkbox path="gustosAct.arte" label=" Arte" value="true" />
            <form:checkbox path="gustosAct.cocina" label=" Cocina" value="true" />
            <form:checkbox path="gustosAct.deporte" label=" Deporte" value="true" />
            <form:checkbox path="gustosAct.fiestas" label=" Fiestas" value="true" />
            <form:checkbox path="gustosAct.fumador" label=" Fumador" value="true" />
            <form:checkbox path="gustosAct.hijos" label=" ¿Tienes hijos?" value="true" />
            <form:checkbox path="gustosAct.lectura" label=" Lectura" value="true" />
            <form:checkbox path="gustosAct.lgtv_friendly" label=" Lgtv+ Friendly" value="true" />
            <form:checkbox path="gustosAct.mascotas" label=" Mascotas" value="true" />
            <form:checkbox path="gustosAct.musica" label=" Musica" value="true" />
            <form:checkbox path="gustosAct.peliculas" label=" Peliculas" value="true" />
            <form:checkbox path="gustosAct.series" label=" Series" value="true" />
            <form:checkbox path="gustosAct.viajes" label=" Viajes" value="true" />
            <form:checkbox path="gustosAct.videojuegos" label=" VideoJuegos" value="true" />

            <br>
            <form:label path="gustosAct.signo">Seleccione su signo: </form:label>
            <form:select path="gustosAct.signo">
              <form:option path="gustosAct.signo" label="Aries" value="Aries"></form:option>
              <form:option path="gustosAct.signo" label="Tauro" value="Tauro"></form:option>
              <form:option path="gustosAct.signo" label="Géminis" value="Géminis"></form:option>
              <form:option path="gustosAct.signo" label="Cáncer" value="Cáncer"></form:option>
              <form:option path="gustosAct.signo" label="Leo" value="Leo"></form:option>
              <form:option path="gustosAct.signo" label="Virgo" value="Virgo"></form:option>
              <form:option path="gustosAct.signo" label="Libra" value="Libra"></form:option>
              <form:option path="gustosAct.signo" label="Escorpio" value="Escorpio"></form:option>
              <form:option path="gustosAct.signo" label="Sagitario" value="Sagitario"></form:option>
              <form:option path="gustosAct.signo" label="Capricornio" value="Capricornio"></form:option>
              <form:option path="gustosAct.signo" label="Acuario" value="Acuario"></form:option>
              <form:option path="gustosAct.signo" label="Piscis" value="Piscis"></form:option>
            </form:select>
        </fieldset>

        <!-- Tabla de datos de dirección-->
        <fieldset>
          <legend>Información de dirección</legend>
          <form:label path="direccionAct.direccion">Dirección:</form:label>
            <form:input path="direccionAct.direccion"/>

            <form:label path="direccionAct.ciudad">Ciudad:</form:label>
            <form:input path="direccionAct.ciudad"/>

            <form:label path="direccionAct.comuna">Comuna:</form:label>
            <form:input path="direccionAct.comuna"/>
        </fieldset>

        <button type="submit">Enviar</button>
    </form:form>
  </main>
</body>
</html>
