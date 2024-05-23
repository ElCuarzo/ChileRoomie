<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
			<a href="/">
				<img src="/images/rommie-app-logo-original.png" alt="Logo ChileRoomie" style="display: block" />
			</a>
		</div>
		<div class="buscar">
			<c:if test="${empty usuarioActual}">
				<input type="text" list="arriendos" placeholder="¿Qué estás buscando?" />
			</c:if>
			<c:if test="${not empty usuarioActual}">
				<input style="margin-left: 135.872px" class="input_search" type="text" list="arriendos"
					placeholder="¿Qué estás buscando?" />
			</c:if>
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
				<div>
					<a href="/perfil/${usuarioActual.id}"><button>Perfil</button></a>
					<a href="/logout"><button>Cerrar sesion</button></a>
				</div>
			</c:if>
		</div>
	</header>

	<div class="welcome">
		<div class="welcome-text">
			<h1>
				La mejor forma de encontrar <span id="tipo-arriendo" style="color:#28a745;">roomie</span>
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
			<img src="/images/home-images/https___23b4d640964e3d924b540388bada03d0.cdn.bubble.io_f1704731328962x801152398947653900_1.png"
				alt="Imagen Roomies" style="width: 105%" />
		</div>
	</div>

	<div class="filtro">
		<form onsubmit="return removeEmptyFields(this)" action="/" method="get">
			<label for="lugar">Lugar</label>
			<select name="lugar" id="filtro">
				<option value="" disabled selected>-Seleccionar-</option>
				<option value="Concepcion">Concepcion</option>
				<option value="Los Ángeles">Los Ángeles</option>
				<option value="San Pedro">San Pedro</option>
				<option value="Talcahuano">Talcahuano</option>
				<option value="Hualpén">Hualpén</option>
				<option value="Hualqui">Hualqui</option>
				<option value="Chiguayante">Chiguayante</option>
			</select>

			<span for="presupuesto">Presupuesto</span>
			<label for="budgetMin">Mínimo</label>
			<input type="number" name="budgetMin" id="presupuestoMin" />
			<label for="budgetMax">Máximo</label>
			<input type="number" name="budgetMax" id="presupuestoMax" />

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
			<button>Buscar</button>
		</form>
	</div>
	<div class="crearPosteoButton">
		<c:if test="${not empty usuarioActual}">
			<a href="/crear/posteo"><button>Publicar Anuncio</button></a>
		</c:if>
	</div>
	<div >
		<c:forEach items="${posteos2D}" var="postRow">
		<div class="main-container">
		<c:forEach items="${postRow}" var="post">
			<!-- Post 1 -->
			<a class="publicacion" href="/publicacion/${post.id}" style="color: black; text-decoration: none">
				<div class="post">
					<div class="post-header">
						<div class="post-username">
							<h2>${post.creador.nombre}, ${post.creador.edad}</h2>
							<img src="/recursos/check.png" alt="Icono de verificado" />
						</div>
						<br />
						<img src="/recursos/${post.imagenes.rutaImagen}" alt="Imagen del arriendo" />
						<p>Precio : ${post.precio}</p>
						<p>${post.direccion.direccion} ${post.direccion.ciudad} ${post.direccion.comuna}</p>
						<p>${post.domicilio}</p>
						<p></p>
					</div>
					<br />
					<div class="post-body">
						<p><b>Descripción:</b></p>
						<p>${post.caracteristica.descripcion}</p>
					</div>
				</div>
			</a>
		</c:forEach>
		</div>
		</c:forEach>
	</div>
	
	<footer>
		<p>
			${xd}	
			Este proyecto fue creado por
			<a href="https://www.linkedin.com/in/fernandogbz/" target="_blank" rel="noopener noreferrer">Fernando
				Jiménez</a>,
			<a href="https://www.linkedin.com/in/diego-lobos-pezo-6b310b296/" target="_blank"
				rel="noopener noreferrer">Diego Lobos</a>,
			<a href="https://www.linkedin.com/in/sebastian-aguayo-segura-b14a36264/" target="_blank"
				rel="noopener noreferrer">Sebastián Aguayo</a>,
			<a href="https://www.linkedin.com/in/fernandogbz/" target="_blank" rel="noopener noreferrer">Christianne
				Alveal</a>
			y
			<a href="https://www.linkedin.com/in/fernandogbz/" target="_blank" rel="noopener noreferrer">Thomas
				Rivero</a>
			usando HTML5, CSS3, JavaScript, Java, Spring Framework y MySQL.
			<br />
			<br />
			<a href="https://github.com/ElCuarzo/ChileRoomie" target="_blank" rel="noopener noreferrer">Código
				Fuente</a>
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

		function removeEmptyFields(form) {
            // Iterate over each element in the form
            for (var i = form.elements.length - 1; i >= 0; i--) {
                var element = form.elements[i];
                // Check if the element is an input or textarea and is empty
                if ((element.tagName === 'INPUT' || element.tagName === 'TEXTAREA') && element.value === '') {
                    // Remove the element from the form
                    element.parentNode.removeChild(element);
                }
            }
            return true; // Continue with form submission
        }
	</script>
</body>

</html>