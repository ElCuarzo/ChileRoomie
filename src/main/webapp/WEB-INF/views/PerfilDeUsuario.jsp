<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil de usuario</title>
    <link rel="stylesheet" href="/css/perfilUsuario.css">
</head>

<body>
    <!-- Banner-->
    <div class="nav-container">
        <a href="#" class="nav-buttonizq">Botón izquierdo</a>
        <a href="/logout" class="nav-buttonder">Cerrar sesion</a>
    </div>
    <main class="main">
        <!-- Caja de información-->
        <section class="section">
            <div class="izq-img">
                <!-- Incorporar imagen-->
                <img src="" alt="">
                <p>Imagen, imagen, imagen, imagen, imagen, imagen, imagen, imagen, imagen, imagen.Imagen, imagen,
                    imagen, imagen, imagen, imagen, imagen, imagen, imagen, imagen.Imagen, imagen, imagen, imagen,
                    imagen, imagen, imagen, imagen, imagen, imagen.Imagen, imagen, imagen, imagen, imagen, imagen,
                    imagen, imagen, imagen, imagen.Imagen, imagen, imagen, imagen, imagen, imagen, imagen, imagen,
                    imagen, imagen.Imagen, imagen, imagen, imagen, imagen, imagen, imagen, imagen, imagen, imagen.</p>
            </div>
            <aside class="aside">
                <div class="caja-1">
                    <h3>Nombre Usuario, ${usuario.nombre}</h3>
                    <h3>Universidad, ${usuario.universidad}</h3>
                </div>
                <div class="cajas">
                    <div class="cajaizq">
                        <h3>Descripcion del Usuario</h3>
                        <br>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna
                            aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                            ex ea commodo consequat. Duis
                            aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
                            pariatur. Excepteur sint
                            occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est
                            laborum.</p>
                    </div>
                    <div class="cajader">
                        <h3>Gustos del Usuario</h3>
                        <br>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna
                            aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
                            ex ea commodo consequat. Duis
                            aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
                            pariatur. Excepteur sint
                            occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est
                            laborum.</p>
                    </div>
                </div>
                <div></div>
            </aside>
        </section>
    </main>
</body>

</html>