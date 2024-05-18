<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
    <link rel="stylesheet" href="/css/Home.css">
  </head>
  <body>
    <header>
      <div class="registro">
        <a href="/login"><button>Login</button></a>
        <c:if test="${not empty usuarioActual}">
          <a href="/perfil/${usuarioActual.id}">Perfil</a>
          <a href="/logout"><button>Cerrar sesion</button></a>
        </c:if>
      </div>
    </header>

    <div class="container">
      <form action="/filtro" method="post">
        <label for="lugar">Lugar</label>
        <select name="lugar" id="filtro">
          <option value="">-Seleccionar-</option>
          <option value="">Concepcion</option>
          <option value="">Los Ángeles</option>
          <option value="">San Pedro</option>
          <option value="">Talcahuano</option>
          <option value="">Hualpén</option>
          <option value="">Hualqui</option>
          <option value="">Chiguayante</option>
        </select>

        <label for="presupuesto">Presupuesto</label>
        <label for="presupuesto">Máximo</label>
        <input type="number" name="presupuesto" id="presupuestoMax" />
        <label for="presupuesto">Mínimo</label>
        <input type="number" name="presupuesto" id="presupuestoMin" />

        <label for="universidad">Universidad</label>
        <select name="universidad" id="filtro"></select>
      </form>
    </div>
    <div>
      <c:if test="${not empty usuarioActual}">
        <a href="/crear/posteo"><button>Publicar Anuncio</button></a>
      </c:if>
    </div>
    <div class="main-content">
      <div class="post">
        <div class="post-header">
          <c:forEach var="posteo" items="${posteos}">
            <h2>${posteo.creador.nombre}</h2>
            <img src="/recursos/${posteo.imagenes.rutaImagen}" alt="Imagen del arriendo" style="max-width: 20%;">
            <p>${posteo.domicilio}</p>
            <p>${posteo.precio}</p>
            <p>
              ${posteo.direccion.direccion}, ${posteo.direccion.ciudad},
              ${posteo.direccion.comuna}
            </p>
          </c:forEach>
        </div>
        <div class="post-body">
          <p>Descripción</p>
        </div>
        <div class="post-footer">
          <button>Ver más</button>
        </div>
      </div>
    </div>
  </body>
</html>
