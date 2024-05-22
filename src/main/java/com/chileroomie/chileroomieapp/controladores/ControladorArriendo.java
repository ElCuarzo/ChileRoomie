package com.chileroomie.chileroomieapp.controladores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chileroomie.chileroomieapp.modelos.Arriendo;
import com.chileroomie.chileroomieapp.modelos.Caracteristica;
import com.chileroomie.chileroomieapp.modelos.Direccion;
import com.chileroomie.chileroomieapp.modelos.FormularioCrear;
import com.chileroomie.chileroomieapp.modelos.FormularioUsuario;
import com.chileroomie.chileroomieapp.modelos.Gusto;
import com.chileroomie.chileroomieapp.modelos.Imagenes;
import com.chileroomie.chileroomieapp.modelos.Usuario;
import com.chileroomie.chileroomieapp.repositorios.ArriendoRepositorio;
import com.chileroomie.chileroomieapp.repositorios.CaracteristicaRepositorio;
import com.chileroomie.chileroomieapp.repositorios.DireccionRepositorio;
import com.chileroomie.chileroomieapp.repositorios.ImagenesRepositorio;
import com.chileroomie.chileroomieapp.servicios.ArriendoServicio;
import com.chileroomie.chileroomieapp.servicios.DireccionServicio;
import com.chileroomie.chileroomieapp.servicios.GustoServicio;
import com.chileroomie.chileroomieapp.servicios.ImagenesServicio;
import com.chileroomie.chileroomieapp.servicios.LoginServicio;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorArriendo {
    
    @Autowired
    private ArriendoRepositorio arriendoRep;

    @Autowired
    private DireccionRepositorio direccionRep;

    @Autowired
    private DireccionServicio direccionSer;

    @Autowired
    private CaracteristicaRepositorio caracteristicaRep;

    @Autowired
    private LoginServicio loginSer;

    @Autowired
    private ImagenesRepositorio imagenesRep;

    @Autowired
    private ImagenesServicio imagenSer;

    @Autowired
    private ArriendoServicio arriendoSer;

    @Autowired
    private GustoServicio gustoSer;

    // Recurso implementado
    @RequestMapping("/")
    public String paginDeInicio(Model modelo, HttpSession sesion){
        List<Arriendo> posteos = (List<Arriendo>) arriendoRep.findAll();
        modelo.addAttribute("posteos", posteos);
        if(sesion.getAttribute("idUsuario") != null){
            Long idUsuarioActual = (Long) sesion.getAttribute("idUsuario");
            Usuario usuarioActual = loginSer.selectPorId(idUsuarioActual);
            modelo.addAttribute("usuarioActual", usuarioActual);
        }
        return "Home.jsp";
    }

    //Recurso implementando junto a su funcionalidad
    @RequestMapping("/crear/posteo")
    public String CrearPosteo(@ModelAttribute("formularioCrear") FormularioCrear formularioCrear, HttpSession sesion){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/";
        }
        return "Posteo.jsp";
    }

    //Recurso implementado
    @RequestMapping(value="/procesar/posteo", method= RequestMethod.POST)
    public String ProcesarPosteo(@Valid @ModelAttribute("formularioCrear") FormularioCrear formularioCrear,
                                BindingResult resultadoFormulario, HttpSession sesion, @RequestParam("file") MultipartFile imagen)
                                {
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/";
        } 
        if(resultadoFormulario.hasErrors()){
            System.out.println("Error en el formulario");
            return "Poste.jsp";
        }

        Usuario usuarioActual = loginSer.selectPorId(idUsuario);

        Arriendo arriendo = formularioCrear.getArriendoAct();
        Caracteristica caracteristica = formularioCrear.getCaracteristicaAct();
        Direccion direccion = formularioCrear.getDireccionAct();

        Arriendo arriendoActual = formularioCrear.getArriendoAct();

        arriendoSer.saveArriendo(arriendoActual);
        caracteristicaRep.save(caracteristica);
        direccionSer.saveDireccion(direccion);
        arriendoActual.setCaracteristica(caracteristica);
        arriendoActual.setDireccion(direccion);
        arriendoActual.setCreador(usuarioActual);
        arriendoActual.setEstadoDeArriendo("Disponible");

        try{
            //Crear fecha en formato simple
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String formatoFecha = sdf.format(now);

            //Determinar la ruta absoluta del archivo
            String rutaAbsoluta = "C://Producto//recursos";
            byte[] bytesImg = imagen.getBytes();

            //Determinar la ruta y el nombre del archivo mas la fecha actual y deteminar su path
            Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + formatoFecha + "_" + imagen.getOriginalFilename());

            //Escribir en la ruta determinada el archuivo (crearlo)
            Files.write(rutaCompleta, bytesImg);

            //Asignar la ruta de la iamgen creada al usuario
            Imagenes nuevaImagen = new Imagenes(formatoFecha + "_" + imagen.getOriginalFilename());
            arriendoActual.setImagenes(nuevaImagen);
            imagenSer.guardarImagen(nuevaImagen);

        } catch (IOException e) {
            e.printStackTrace();
        }
        usuarioActual.getArriendos().add(arriendo);
        
        return "redirect:/";
    }

    //Recurso implementado
    @RequestMapping("/perfil/{id}")
    public String mostrarPerfil(@PathVariable("id") Long idUsuarioPerfil, 
                                Model modelo, HttpSession sesion){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/";
        }

        Usuario usuario = loginSer.selectPorId(idUsuarioPerfil);
        modelo.addAttribute("usuario", usuario);
        return "PerfilDeUsuario.jsp";
    }

    //Recurso implementado
    @RequestMapping("/perfil/editar/{id}")
    public String editarPerfil(@ModelAttribute("formularioUsuario") FormularioUsuario formularioUsuario,@PathVariable ("id") Long idUsuarioPerfil,
                            Model modelo, HttpSession sesion){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/";
        }
        Usuario usuario = loginSer.selectPorId(idUsuarioPerfil);
        if(usuario.getDireccion() != null){
            formularioUsuario.setDireccionAct(usuario.getDireccion());
        }
        if(usuario.getGustos() != null){
            formularioUsuario.setGustosAct(usuario.getGustos());
        }
        if(usuario.getImagenes() != null){
            formularioUsuario.setImagenenAct(usuario.getImagenes());
        }
        if(usuario.getGenero() != null || usuario.getTelefono() != null || usuario.getUniversidad() != null || usuario.getNombre() != null || usuario.getApellido() != null || usuario.getEdad() != 0){
            formularioUsuario.setUsuarioAct(usuario);
        }
        modelo.addAttribute("usuario", usuario);
        return "EditarPerfilUsuario.jsp";
    }

    @RequestMapping(value="/perfil/editar/{id}", method= RequestMethod.POST)
    public String procesarEditarPerfil(@Valid @ModelAttribute("formularioUsuario") FormularioUsuario formularioUsuario,
                                    BindingResult resultadoFormulario, @RequestParam("file") MultipartFile imagen,
                                    @PathVariable("id") Long idUsuarioActual, HttpSession sesion) {
    Long idUsuario = (Long) sesion.getAttribute("idUsuario");
    if(idUsuario == null){
        return "redirect:/";
    }

    if(resultadoFormulario.hasErrors()){
        System.out.println("Error en el formulario");
        return "EditarPerfilUsuario.jsp";
    }

    Usuario usuario = loginSer.selectPorId(idUsuarioActual);

    //Verficación que maneja si existe la dirección (si no existe lo crea, si existe lo actualiza)
    if (usuario.getDireccion() == null) {
        Direccion nuevaDireccion = formularioUsuario.getDireccionAct();
        direccionRep.save(nuevaDireccion);
        usuario.setDireccion(nuevaDireccion);
    } else {
        direccionSer.actualizarGustos(formularioUsuario, usuario);
    }

    //Verficicación que maneja si existe el gusto (si no existe lo crea, si existe lo actualiza)
    if(usuario.getGustos() == null){
        Gusto gusto = formularioUsuario.getGustosAct();
        gustoSer.saveGusto(gusto);
        usuario.setGustos(gusto);
    } else {
        gustoSer.actualizarGustos(formularioUsuario, usuario);
    }

    //Verficicación en caso de que exista o no maneja un set para el parametro.
    if(usuario.getGenero() == null || usuario.getTelefono() == null || usuario.getUniversidad() == null || usuario.getApellido() == null || usuario.getEdad() == 0){
        usuario.setGenero(formularioUsuario.getUsuarioAct().getGenero());
        usuario.setTelefono(formularioUsuario.getUsuarioAct().getTelefono());
        usuario.setUniversidad(formularioUsuario.getUsuarioAct().getUniversidad());
        usuario.setApellido(formularioUsuario.getUsuarioAct().getApellido());
        usuario.setEdad(formularioUsuario.getUsuarioAct().getEdad());
        usuario.setNombre(formularioUsuario.getUsuarioAct().getNombre());
    } else {
        usuario.setGenero(formularioUsuario.getUsuarioAct().getGenero());
        usuario.setTelefono(formularioUsuario.getUsuarioAct().getTelefono());
        usuario.setUniversidad(formularioUsuario.getUsuarioAct().getUniversidad());
        usuario.setApellido(formularioUsuario.getUsuarioAct().getApellido());
        usuario.setEdad(formularioUsuario.getUsuarioAct().getEdad());
        usuario.setNombre(formularioUsuario.getUsuarioAct().getNombre());
    }

    //Validaciones para la imagen (en caso de estar presente la imagen tanto en el formulario como en la id)
    //En caso de existir la elimina y en caso de no existir la guarda y la adjunta al usuario.
    Imagenes existenteImagen = usuario.getImagenes();
    if (existenteImagen != null && existenteImagen.getId() != null) {
        if(!imagen.isEmpty()){
        // Eliminar la imagen existente del sistema de archivos
        String rutaImagenExistente = existenteImagen.getRutaImagen();
        try {
            Files.deleteIfExists(Paths.get(rutaImagenExistente));
            usuario.setImagenes(null);
            imagenSer.eliminarImagen(existenteImagen);
        } catch (IOException e) {
            // Manejar cualquier error que ocurra al eliminar la imagen existente del sistema de archivos
            e.printStackTrace();
        }
    }
}

    // Guardar la nueva imagen
    try {
        //Crear fecha en formato simple
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatoFecha = sdf.format(now);

        //Determinar la ruta absoluta del archivo
        String rutaAbsoluta = "C://Producto//recursos";
        byte[] bytesImg = imagen.getBytes();

        //Determinar la ruta y el nombre del archivo mas la fecha actual y deteminar su path
        String nombreArchivo = formatoFecha + "_" +  imagen.getOriginalFilename();
        Path rutaCompleta = Paths.get(rutaAbsoluta, nombreArchivo);

        //Escribir en la ruta determinada el archivo (crearlo)
        Files.write(rutaCompleta, bytesImg);

        //Asignar la ruta de la imagen creada al usuario
        Imagenes nuevaImagen = new Imagenes(rutaCompleta.toString());
        usuario.setImagenes(nuevaImagen);
        imagenSer.guardarImagen(nuevaImagen);

    } catch (IOException e) {
        // Manejar cualquier error que ocurra al guardar la nueva imagen
        e.printStackTrace();
    }

    // Actualizar al usuario
    loginSer.actualizarUsuario(usuario);
    return "redirect:/perfil/" + idUsuarioActual;
    }

    //Recurso implementado
    @RequestMapping("/posteo/{id}")
    public String mostrarPosteo(@PathVariable ("id") Long idPosteo,
                                Model modelo, HttpSession sesion){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/";
        }

        Arriendo posteo = arriendoSer.findArriendoById(idPosteo);
        modelo.addAttribute("posteo", posteo);
        return "Publicacion.jsp";
    }

    //Recurso implementado (falta su método POST)
    @RequestMapping("/posteo/editar/{id}")
    public String editarPosteo(@PathVariable("id") Long idPosteo,
                                Model modelo, HttpSession sesion){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/";
        }

        Arriendo posteo = arriendoSer.findArriendoById(idPosteo);
        modelo.addAttribute("posteo", posteo);
        return "EditarPublicacion.jsp";
    }

    //Recurso implementado
    @RequestMapping("/eliminar/posteo/{id}")
    public String eliminarPosteo(@PathVariable ("id") Long idPosteo, HttpSession sesion){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/";
        }

        Arriendo arriendoActual = arriendoSer.findArriendoById(idPosteo);

        arriendoSer.deleteArriendo(arriendoActual);
        return "redirect:/";
    }

    @RequestMapping("/publicacion/{id}")
    public String verPublicacion(@PathVariable("id") Long idPosteo, Model modelo, HttpSession sesion){
        Arriendo arriendo = arriendoSer.findArriendoById(idPosteo);
        modelo.addAttribute("arriendo", arriendo);
        if(sesion.getAttribute("idUsuario") != null){
            Long idUsuarioActual = (Long) sesion.getAttribute("idUsuario");
            Usuario usuarioActual = loginSer.selectPorId(idUsuarioActual);
            modelo.addAttribute("usuarioActual", usuarioActual);
        }
        return "Publicacion.jsp";
    }
}
