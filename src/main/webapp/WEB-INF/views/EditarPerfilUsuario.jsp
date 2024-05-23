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
          <div class="center-info-user">
            <div class="info-user">
              <div class="main-information">
                <div class="info">
                  <form:label path="usuarioAct.nombre">Nombre: </form:label>
                  <form:input type="text" path="usuarioAct.nombre"/>
                </div>
                <div class="info">
                  <form:label path="usuarioAct.apellido">Apellido: </form:label>
                  <form:input type="text" path="usuarioAct.apellido" required="true"/>
                </div>
                
                <div class="info">
                  <form:label path="usuarioAct.edad">Edad: </form:label>
                  <form:input type="number" path="usuarioAct.edad" min="18" max="27"/>
                </div>

                <div class="info">
                  <form:label path="usuarioAct.telefono">Télefono:</form:label>
                  <form:input type="tel" path="usuarioAct.telefono" id="phone" class="phone-input" maxlength="12" value="+569"></form:input>
                </div>
                <div class="info">
                  <form:label path="usuarioAct.universidad">Universidad:</form:label>
                  <form:select path="usuarioAct.universidad" required="true">
                    <form:option path="usuarioAct.universidad" label="" value="">-Seleccionar-</form:option>
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
                </div>
              </div>
              <div class="genero">
                <p>¿Con que genero te identificas?</p>
                <div class="genero-info">
                  <form:radiobutton path="usuarioAct.genero" value="He"/><p>Masculino:</p>
                </div>
                <div class="genero-info">
                  <form:radiobutton path="usuarioAct.genero" value="She"/><p>Femenino:</p>
                </div>
                <div class="genero-info">
                  <form:radiobutton path="usuarioAct.genero" value=""/><p>No especificar:</p>
                </div>
                <br>
                <div class="imagen">
                  <label for="imagen">Imagen</label>
                  <input type="file" name="file" accept=".jpg, .png">
                  <p>Solo imagenes con formato JPG y PNG (de hasta 10MB)</p>
                </div>
              </div>
            </div>
            <div class="descripcion">
              <label for="descripcion">Descripcion:</label>
              <textarea name="descripcion" id="descripcion" cols="30" rows="10" required="true"></textarea>
            </div>
          </div>
        </fieldset>
      
      <!-- Tabla de datos de dirección-->
      <fieldset>
        <legend>Información de dirección</legend>
        <form:label path="direccionAct.direccion">Dirección:</form:label>
          <form:input path="direccionAct.direccion" required="true"/>

          <form:label path="direccionAct.ciudad">Ciudad:</form:label>
          <form:input path="direccionAct.ciudad" required="true"/>

          <form:label path="direccionAct.comuna">Comuna:</form:label>
          <form:input path="direccionAct.comuna" required="true"/>


      </fieldset>

        <!-- Tabla de gustos del usuario -->
        <fieldset>

          <legend>Información gustos usuario</legend>
          <div class="info-gustos">
          <div class="gustos-usuario">
            <div class="gustos-separador">
              <div class="gusto">
                <form:checkbox path="gustosAct.anime" label=" Anime" value="true" />
            </div>
            <div class="gusto">
              <form:checkbox path="gustosAct.arte" label=" Arte" value="true" />
            </div>
            <div class="gusto">
              <form:checkbox path="gustosAct.cocina" label=" Cocina" value="true" />
            </div>
            <div class="gusto">
              <form:checkbox path="gustosAct.deporte" label=" Deporte" value="true" />
            </div>
            <div class="gusto">
              <form:checkbox path="gustosAct.fiestas" label=" Fiestas" value="true" />
            </div>
          </div>
          <div class="gustos-separador">
            <div class="gusto">
              <form:checkbox path="gustosAct.fumador" label=" Fumador" value="true" />
            </div>
            <div class="gusto">
              <form:checkbox path="gustosAct.hijos" label=" ¿Tienes hijos?" value="true" />
            </div>
            <div class="gusto">
              <form:checkbox path="gustosAct.lectura" label=" Lectura" value="true" />
            </div>
            <div class="gusto">
              <form:checkbox path="gustosAct.lgtv_friendly" label=" Lgtv+ Friendly" value="true" />
            </div>
            <div class="gusto">
              <form:checkbox path="gustosAct.mascotas" label=" Mascotas" value="true" />
            </div>
          </div>
          <div class="gustos-separador">
            <div class="gusto">
              <form:checkbox path="gustosAct.musica" label=" Musica" value="true" />
            </div>
            <div class="gusto">
              <form:checkbox path="gustosAct.peliculas" label=" Peliculas" value="true" />
            </div>
            <div class="gusto">
              <form:checkbox path="gustosAct.series" label=" Series" value="true" />
            </div>
            <div class="gusto">
              <form:checkbox path="gustosAct.viajes" label=" Viajes" value="true" />
            </div>
            <div class="gusto">
              <form:checkbox path="gustosAct.videojuegos" label=" VideoJuegos" value="true" />
            </div>
          </div>
          </div>
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
          </div>
        </fieldset>

        <div class="send-button">
          <a href="/"><button class="cancel">Cancelar</button></a>
          <button type="submit">Enviar</button>
        </div>
    </form:form>
  </main>

  <script>
    document.addEventListener('DOMContentLoaded', (event) => {
        const phoneInput = document.getElementById('phone');

        phoneInput.addEventListener('focus', (event) => {
            if (!phoneInput.value.startsWith('+56')) {
                phoneInput.value = '+56';
            }
        });

        phoneInput.addEventListener('keydown', (event) => {
            const value = phoneInput.value;
            const cursorPos = phoneInput.selectionStart;
            console.log(event)

            // Prevent deleting the prefix
            if ((event.key === 'Backspace' || event.key === 'Delete') && cursorPos <= 4) {
                event.preventDefault();
            }

            // Prevent cursor from moving left of the prefix
            if (event.key === 'ArrowLeft' && cursorPos <= 3) {
                event.preventDefault();
            }

            // Prevent non-numeric input except for control keys
            if (!/[0-9]/.test(event.key) && !['Backspace', 'Delete', 'ArrowLeft', 'ArrowRight', 'Tab'].includes(event.key)) {
                event.preventDefault();
            }
        });

        phoneInput.addEventListener('beforeinput', (event) => {
            if (event.inputType === 'deleteContentBackward' && phoneInput.selectionStart <= 4) {
                event.preventDefault();
            }
        });

        phoneInput.addEventListener('input', (event) => {
            if (!phoneInput.value.startsWith('+569')) {
                phoneInput.value = '+569' + phoneInput.value.replace('+569', '');
            }
            
            // Remove non-numeric characters
            phoneInput.value = '+56' + phoneInput.value.slice(3).replace(/[^0-9]/g, '');
        });
    });
</script>
</body>
</html>
