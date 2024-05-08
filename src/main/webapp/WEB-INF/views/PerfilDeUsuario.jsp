<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registro casi completado</title>
  </head>

  <body>
    <header>
      <a href="/logout"><button>Cerrar sesion</button></a>
      <h1>${usuario.nombre}</h1>
      <p>${usuario.genero}</p>
      <p>${usuario.universidad}</p>
    </header>
  </body>
</html>
