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
        <h1>
          La mejor forma de encontrar <span id="tipo-arriendo">roomie</span>
        </h1>
        <p>
          Te conectamos con miles de inquilinos que buscan compañeros de
          habitación y publican habitaciones que no puedes encontrar en ningún
          otro lugar. Deje de estresarse y permítanos ayudarle a encontrar la
          opción adecuada.
        </p>
        <a href="/login"><button>Empieza ya</button></a>
      </div>
      <div class="welcome-img">
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
        <select name="universidad" id="filtro">
          <option value="" disabled selected>-Seleccionar-</option>
          <option value="Universidad del Bio-Bio">
            Universidad del Bio-Bio
          </option>
          <option value="Universidad de Concepción">
            Universidad de Concepción
          </option>
          <option value="Virginio Goméz">Virginio Goméz</option>
          <option value="Inacap">Inacap</option>
          <option value="Santo Tomás">Santo Tomás</option>
          <option value="Universidad San Sebastian">
            Universidad San Sebastian
          </option>
          <option value="Universidad del Desarrollo">
            Universidad del Desarrollo
          </option>
          <option value="Universidad Catolica de la Santísima Concepción">
            Universidad Catolica de la Santísima Concepción
          </option>
          <option value="Universidad Andrés Bello">
            Universidad Andrés Bello
          </option>
          <option value="Universidad Técnica Federico Santa Maria">
            Universidad Técnica Federico Santa Maria
          </option>
          <option value="Duoc UC">Duoc UC</option>
        </select>
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
            <div class="post-username">
              <h2>Fernando, 23</h2>
              <img src="/recursos/check.png" alt="Icono de verificado" />
            </div>
            <br />
            <img src="/recursos/casa1.jpeg" alt="Imagen del arriendo" />
            <p>Precio : 500.000</p>
            <p>Sor Vicenta 244, Los Ángeles</p>
            <p>Casa</p>
            <p></p>
          </div>
          <br />
          <div class="post-body">
            <p><b>Descripción:</b></p>
            <p>
              Casa en el centro, dentro de la comuna de Los Ángeles, con acceso
              a universidades y locomoción publica, cerca del mall.
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
            <div class="post-username">
              <h2>Diego, 22</h2>
              <img src="/recursos/check.png" alt="Icono de verificado" />
            </div>
            <br />
            <img
              src="/recursos/20240518152335_Arriendo_Depa_1.png"
              alt="Imagen del arriendo"
            />
            <p>Precio : 457.000</p>
            <p>Santa Isabel 860, Santiago Centro</p>
            <p>Departamento</p>
            <p></p>
          </div>
          <br />
          <div class="post-body">
            <p><b>Descripción:</b></p>
            <p>
              Departamento centrico dentro de la comuna de concepción, con
              acceso a universidades y locomoción publica
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
            <div class="post-username">
              <h2>Sebastián, 19</h2>
              <img src="/recursos/check.png" alt="Icono de verificado" />
            </div>
            <br />
            <img src="/recursos/casa2.jpg" alt="Imagen del arriendo" />
            <p>Precio : 350.000</p>
            <p>Las Azaleas 192, Concepción</p>
            <p>Casa</p>
            <p></p>
          </div>
          <br />
          <div class="post-body">
            <p><b>Descripción:</b></p>
            <p>Casa amplia dentro de la comuna de concepción.</p>
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
            <div class="post-username">
              <h2>Christianne, 20</h2>
              <img src="/recursos/check.png" alt="Icono de verificado" />
            </div>
            <br />
            <img src="/recursos/images.jpg" alt="Imagen del arriendo" />
            <p>Precio : 470.000</p>
            <p>Los lirios 375, Concepción, Barrio Norte</p>
            <p>Departamento</p>
            <p></p>
          </div>
          <br />
          <div class="post-body">
            <p><b>Descripción:</b></p>
            <p>
              Deparamento centrico dentro de la comuna de concepción, con acceso
              a universidades y locomoción publica
            </p>
          </div>
        </div>
      </a>
    </div>
    <footer>
      <p>
        Este proyecto fue creado por
        <a
          href="https://www.linkedin.com/in/fernandogbz/"
          target="_blank"
          rel="noopener noreferrer"
          >Fernando Jiménez</a
        >,
        <a
          href="https://www.linkedin.com/in/fernandogbz/"
          target="_blank"
          rel="noopener noreferrer"
          >Diego Lobos</a
        >,
        <a
          href="https://www.linkedin.com/in/fernandogbz/"
          target="_blank"
          rel="noopener noreferrer"
          >Sebastián Aguayo</a
        >,
        <a
          href="https://www.linkedin.com/in/fernandogbz/"
          target="_blank"
          rel="noopener noreferrer"
          >Christianne Alveal</a
        >
        y
        <a
          href="https://www.linkedin.com/in/fernandogbz/"
          target="_blank"
          rel="noopener noreferrer"
          >Thomas Rivero</a
        >
        usando HTML5, CSS3, JavaScript, Java, Spring Framework y MySQL.
        <br />
        <br />
        <a
          href="https://github.com/ElCuarzo/ChileRoomie"
          target="_blank"
          rel="noopener noreferrer"
          >Código Fuente</a
        >
      </p>
    </footer>

    <script>
      const tipoArriendo = document.getElementById("tipo-arriendo");
      const text_1 = tipoArriendo.textContent;
      const text_2 = "arriendo";
      const text_3 = "alquiler";
      let currentIndex = 0;
      let isDeleting = false;
      let text = text_1;
      textos = [text_1, text_2, text_3];
      styles = ["color: #28a745;", "color: blue;", "color: purple;"];
      let i = 0;

      function type() {
        if (isDeleting) {
          tipoArriendo.textContent = text.substring(0, currentIndex - 1);
          currentIndex--;
          if (currentIndex === 0) {
            isDeleting = false;
            i++;
            text = textos[i % textos.length];
            tipoArriendo.style = styles[i % styles.length];
            setTimeout(type, 500);
            return;
          }
        } else {
          tipoArriendo.textContent = text.substring(0, currentIndex + 1);
          currentIndex++;
          if (currentIndex === text.length) {
            isDeleting = true;
            setTimeout(type, 1000);
            return;
          }
        }
        setTimeout(type, 100);
      }
      type();
    </script>
  </body>
</html>
