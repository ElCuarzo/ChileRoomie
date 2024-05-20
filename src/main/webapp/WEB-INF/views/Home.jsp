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
    <link rel="stylesheet" href="/css/Home.css" />
  </head>
  <body>
    <header>
      <div class="logo">
        <img
          src="/images/rommie-app-logo-original.png"
          alt="Logo ChileRoomie"
          style="display: block"
        />
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
        <a href="/login"><button>Login</button></a>
        <c:if test="${not empty usuarioActual}">
          <a href="/perfil/${usuarioActual.id}"><button>Perfil</button></a>
          <a href="/logout"><button>Cerrar sesion</button></a>
        </c:if>
      </div>
    </header>

    <div class="welcome">
      <div class="welcome-text">
        <h1>Bienvenido a ChileRoomie</h1>
        <p>
          Encuentra la mejor <span>habitación</span> para ti, en la ciudad que
          prefieras.
        </p>
      </div>
      <div style="width: 27%; display: flex">
        <img
          src="/images/home-images/https___23b4d640964e3d924b540388bada03d0.cdn.bubble.io_f1704731328962x801152398947653900_1.png"
          alt="Imagen Roomies"
          style="width: 105%"
        />
      </div>
    </div>

    <div class="filtro">
      <form action="/filtro" method="post">
        <label for="lugar">Lugar</label>
        <select name="lugar" id="filtro">
          <option value="" disabled selected>-Seleccionar-</option>
          <option value="">Concepcion</option>
          <option value="">Los Ángeles</option>
          <option value="">San Pedro</option>
          <option value="">Talcahuano</option>
          <option value="">Hualpén</option>
          <option value="">Hualqui</option>
          <option value="">Chiguayante</option>
        </select>

        <span for="presupuesto">Presupuesto</span>
        <label for="presupuesto">Mínimo</label>
        <input type="number" name="presupuesto" id="presupuestoMin" />
        <label for="presupuesto">Máximo</label>
        <input type="number" name="presupuesto" id="presupuestoMax" />

        <label for="universidad">Universidad</label>
        <select name="universidad" id="filtro"></select>
      </form>
    </div>
    <div class="crearPosteoButton">
      <c:if test="${not empty usuarioActual}">
        <a href="/crear/posteo"><button>Publicar Anuncio</button></a>
      </c:if>
    </div>
    <div class="main-container">
      <!-- Post 1 -->
      <a
        class="publicacion"
        href="/publicacion/1"
        style="color: black; text-decoration: none"
      >
        <div class="post">
          <div class="post-header">
            <h2>Diego</h2>
            <br />
            <img
              src="/recursos/20240518152335_Arriendo_Depa_1.png"
              alt="Imagen del arriendo"
              style="max-width: 20%"
            />
            <p>Precio : 457.000</p>
            <p>Los lirios 375, Concepción, Barrio Norte</p>
            <p>Departamento</p>
            <p></p>
          </div>
          <br />
          <div class="post-body">
            <p>Descripción</p>
            <p>
              Deparamento centrico dentro de la comuna de concepción, con acceso
              a universidades y locomoción publica
            </p>
          </div>
        </div>
      </a>
      <!-- Post 2 -->
      <a
        class="publicacion"
        href="/publicacion/1"
        style="color: black; text-decoration: none"
      >
        <div class="post">
          <div class="post-header">
            <h2>Diego</h2>
            <br />
            <img
              src="/recursos/20240518152335_Arriendo_Depa_1.png"
              alt="Imagen del arriendo"
              style="max-width: 20%"
            />
            <p>Precio : 457.000</p>
            <p>Los lirios 375, Concepción, Barrio Norte</p>
            <p>Departamento</p>
            <p></p>
          </div>
          <br />
          <div class="post-body">
            <p>Descripción</p>
            <p>
              Deparamento centrico dentro de la comuna de concepción, con acceso
              a universidades y locomoción publica
            </p>
          </div>
        </div>
      </a>
      <!-- Post 3 -->
      <a
        class="publicacion"
        href="/publicacion/1"
        style="color: black; text-decoration: none"
      >
        <div class="post">
          <div class="post-header">
            <h2>Diego</h2>
            <br />
            <img
              src="/recursos/20240518152335_Arriendo_Depa_1.png"
              alt="Imagen del arriendo"
              style="max-width: 20%"
            />
            <p>Precio : 457.000</p>
            <p>Los lirios 375, Concepción, Barrio Norte</p>
            <p>Departamento</p>
            <p></p>
          </div>
          <br />
          <div class="post-body">
            <p>Descripción</p>
            <p>
              Deparamento centrico dentro de la comuna de concepción, con acceso
              a universidades y locomoción publica
            </p>
          </div>
        </div>
      </a>
      <!-- Post 4 -->
      <a
        class="publicacion"
        href="/publicacion/1"
        style="color: black; text-decoration: none"
      >
        <div class="post">
          <div class="post-header">
            <h2>Diego</h2>
            <br />
            <img
              src="/recursos/20240518152335_Arriendo_Depa_1.png"
              alt="Imagen del arriendo"
              style="max-width: 20%"
            />
            <p>Precio : 457.000</p>
            <p>Los lirios 375, Concepción, Barrio Norte</p>
            <p>Departamento</p>
            <p></p>
          </div>
          <br />
          <div class="post-body">
            <p>Descripción</p>
            <p>
              Deparamento centrico dentro de la comuna de concepción, con acceso
              a universidades y locomoción publica
            </p>
          </div>
        </div>
      </a>
    </div>
  </body>
</html>
