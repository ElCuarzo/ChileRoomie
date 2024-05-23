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
    <link rel="stylesheet" href="/css/Publicacion.css" />
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
        <c:if test="${empty usuarioActual}">
          <a href="/login"><button>Login</button></a>
        </c:if>
        <c:if test="${not empty usuarioActual}">
          <a href="/perfil/${usuarioActual.id}"><button>Perfil</button></a>
          <a href="/logout"><button>Cerrar sesion</button></a>
        </c:if>
      </div>
    </header>
    <main class="main">
      <!-- Caja de información-->
      <!-- Section 1 -->
      <section class="images">
        <div class="images-arriendo">
          <!-- Incorporar imagen-->
          <div class="img-arriendo">
            <img src="/recursos/casa4.jpg" alt="" />
          </div>
          <div class="img-secundarias-arriendo">
            <div class="img-sec-1">
              <img id="img-sec-1" src="/recursos/casa1-interior.jpg" alt="" />
            </div>
            <div class="img-sec-2">
              <img id="img-sec-2" src="/recursos/casa1-interior3.jpg" alt="" />
            </div>
          </div>
        </div>
      </section>

      <!-- Section 2 -->
      <section class="section">
        <aside class="aside">
          <div class="container-info">
            <div class="title-container">
              <a href="/perfil/${usuarioActual.id}"
                ><div class="izq-img">
                  <!-- Incorporar imagen-->
                  <img src="/recursos/satoru.jpg" alt="Imagen Perfil" />
                  <div class="caja-1">
                    <div class="username">
                      <h1>Casa de Fernando ${usuario.nombre} en Los Ángeles</h1>
                      <img
                        src="/recursos/check.png"
                        alt="Icono de verificado"
                      />
                    </div>
                    <p>Dirección: Sor Vicenta 244, Los Ángeles</p>
                  </div>
                </div>
              </a>
              <div class="contact-button">
                <button>Contactar</button>
              </div>
            </div>
            <div class="especificaciones">
              <div class="arriendo-specs">
                <p>Precio:</p>
                <h3>500.000 CLP</h3>
              </div>
              <div class="arriendo-specs">
                <p>Deposito:</p>
                <h3>500.000 CLP</h3>
              </div>

              <div class="arriendo-specs">
                <p>Disponibilidad:</p>
                <p>Disponible desde 01-06-2024 / 12 meses</p>
              </div>
              <div class="arriendo-specs">
                <p>Tipo:</p>
                <p>Casa</p>
              </div>
              <div class="arriendo-specs">
                <p>Habitaciones:</p>
                <p>5</p>
              </div>
              <div class="arriendo-specs">
                <p>Baños:</p>
                <p>3</p>
              </div>
              <br />
            </div>
          </div>
          <div class="cajas">
            <div class="cajaizq">
              <h3>Descripcion:</h3>
              <br />
              <p>
                Casa en el centro, dentro de la comuna de Los Ángeles, con
                acceso a universidades y locomoción publica, cerca del mall.
              </p>
            </div>
            <div class="cajader">
              <h3>Gustos del Usuario:</h3>
              <br />
              <p>
                No tiene ningún pasatiempo, o habilidad especial ya que puede
                hacer de todo. Su comida favorita son las cosas dulces. Su
                bebida menos favorita es el alcohol.
              </p>
            </div>
          </div>
          <c:if test="${empty usuarioActual}">
            <div class="editar-button">
              <button>Editar</button>
            </div>
          </c:if>
        </aside>
      </section>
    </main>
  </body>
</html>
