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
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, Helvetica, sans-serif;
        }

        /*Inicia banner*/
        .nav-container {
            background-color: #B2FFD6;
            color: #fff;
            padding: 0;
            margin: 0;
            height: 80px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .nav-buttonizq {
            background-color: #9bfab0;
            border: none;
            color: white;
            padding: 10px 40px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 0px 100px;
            cursor: pointer;
            border-bottom: 3px solid #7ac78b;
            border-right: 3px solid #7ac78b;
        }

        .nav-buttonder {
            background-color: #f9635c;
            border: none;
            color: white;
            padding: 10px 40px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 0px 100px;
            cursor: pointer;
            border-bottom: 3px solid #c44c46;
            border-right: 3px solid #c44c46;
        }

        .nav-button:hover {
            background-color: #005187;
        }

        /*Finaliza banner*/
        /*Inicia caja de información*/
        .main {
            width: 100%;
            height: 100%;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;

        }

        .section {
            display: flex;
            flex-direction: row;
            padding: 20px;
            background-color: aquamarine;
            width: 80%;
            height: 100%;
            margin-top: 20px;
            border-radius: 10px;
            border-bottom: 3px solid #7ac78b;
            border-right: 3px solid #7ac78b;
            border-left: 3px solid #9bfab0;
            border-top: 3px solid #9bfab0;

        }

        .izq-img {
            background-color: #00D48C;
            margin-right: 20px;
        }

        .caja-1 {
            background-color: #00D48C;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            padding: 10px;
            margin-right: 20px;
            margin-bottom: 20px;
        }

        .cajas {
            display: flex;
            flex-direction: row;
        }

        .cajaizq {
            background-color: #00D48C;
            margin-right: 20px;
            padding: 10px;
        }

        .cajader {
            background-color: #00D48C;
            margin-right: 20px;
            padding: 10px;
        }
    </style>
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