<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Perfil de usuario</title>
    <link rel="stylesheet" href="/css/perfilUsuario.css" />
  </head>

  <body>
    <!-- Banner-->
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
      <div class="buscar">
        <input
          type="text"
          list="arriendos"
          placeholder="¿Qué estás buscando?"
        />
        <datalist id="arriendos">
          <option>Casa</option>
          <option>Departamento</option>
          <option>Pensión</option>
        </datalist>
      </div>
      <div class="login">
        <c:if test="${not empty usuarioActual}">
          <a href="/Logout"><button>Login</button></a>
        </c:if>
        <c:if test="${empty usuarioActual}">
          <div>
            <a href="/logout"><button>Cerrar sesion</button></a>
          </div>
        </c:if>
      </div>
    </header>
    <main class="main">
      <!-- Caja de información-->
      <section class="section">
        <div class="izq-img">
          <!-- Incorporar imagen-->
          <img src="/recursos/a.jpeg" alt="" />
          <div class="ubi">
            <img
              src="/recursos/pasador-de-ubicacion.png"
              alt="Icono de Ubicación"
            />
            <p>Concepción</p>
          </div>
          <div class="ig">
            <img
              src="/recursos/logotipo-de-instagram.png"
              alt="Logo de instagram"
            />
            <a href="https://www.instagram.com/">Instagram</a>
          </div>
          <br />
          <div class="contact-button">
            <a href="https://wa.me/${post.creador.telefono}"
              ><button>Contactar</button></a
            >
          </div>
        </div>
        <aside class="aside">
          <div class="caja-1">
            <div class="username">
              <h1>Nombre: ${usuario.nombre}, 23</h1>
              <img src="/recursos/check.png" alt="Icono de verificado" />
            </div>
            <p>Universidad: ${usuario.universidad}</p>
          </div>
          <div class="cajas">
            <div class="cajaizq">
              <h3>Descripcion del Usuario</h3>
              <br />
              <p>
                Tengo muchas afficciones, me gusta la tranquilidad, muy comunicador y directo.
              </p>
            </div>
            <div class="cajader">
              <h3>Gustos del Usuario:</h3>
              <br />
              <c:if test="${!tieneGustos}">
                <p>No hay información</p>
              </c:if>
              <c:if test="${tieneGustos}">
                <c:forEach items="${gustos.getGustosArray()}" var="gusto">
                  <p>${gusto}</p>
                </c:forEach>
              </c:if>
            </div>
          </div>
          <div class="editar-button">
            <a href="/perfil/editar/${usuario.id}">
              <button>Editar</button>
            </a>
          </div>
        </aside>
      </section>
    </main>
  </body>
</html>
