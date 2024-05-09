package com.chileroomie.chileroomieapp.controladores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public String paginDeInicio(Model modelo){
        List<Arriendo> posteos = (List<Arriendo>) arriendoRep.findAll();
        modelo.addAttribute("posteos", posteos);
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

    //Recurso implementado (falta integrar la funcionalidad de actualizar el usuario)
    @RequestMapping("/perfil/editar/{id}")
    public String editarPerfil(@ModelAttribute("formularioUsuario") FormularioUsuario formularioUsuario,@PathVariable ("id") Long idUsuarioPerfil,
                            Model modelo, HttpSession sesion){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/";
        }
        Usuario usuario = loginSer.selectPorId(idUsuario);
        if(usuario.getDireccion() != null){
            formularioUsuario.setDireccionAct(usuario.getDireccion());
        }
        if(usuario.getGustos() != null){
            formularioUsuario.setGustosAct(usuario.getGustos());
        }
        if(usuario.getImagenes() != null){
            formularioUsuario.setImagenenAct(usuario.getImagenes());
        }
        if(usuario.getGenero() != null || usuario.getTelefono() != null || usuario.getUniversidad() != null){
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

    Usuario usuario = loginSer.selectPorId(idUsuario);

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
    if(usuario.getGenero() == null || usuario.getTelefono() == null || usuario.getUniversidad() == null){
        usuario.setGenero(formularioUsuario.getUsuarioAct().getGenero());
        usuario.setTelefono(formularioUsuario.getUsuarioAct().getTelefono());
        usuario.setUniversidad(formularioUsuario.getUsuarioAct().getUniversidad());
    } else {
        usuario.setGenero(formularioUsuario.getUsuarioAct().getGenero());
        usuario.setTelefono(formularioUsuario.getUsuarioAct().getTelefono());
        usuario.setUniversidad(formularioUsuario.getUsuarioAct().getUniversidad());
    }

    //Validaciones para la imagen (en caso de estar presente la imagen tanto en el formulario como en la id)
    //En caso de existir la elimina y en caso de no existir la guarda y la adjunta al usuario.
    Imagenes existenteImagen = usuario.getImagenes();
    if (existenteImagen != null && existenteImagen.getId() != null) {
        if(!imagen.isEmpty()){
        // Eliminar la imagen existente del sistema de archivos
        String rutaImagenExistente = "C://Producto//recursos//" + existenteImagen.getRutaImagen();
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
        String rutaAbsoluta = "C://Producto//recursos";
        byte[] bytesImg = imagen.getBytes();
        Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
        Files.write(rutaCompleta, bytesImg);

        Imagenes nuevaImagen = new Imagenes(imagen.getOriginalFilename());
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

        for(Imagenes imagen : arriendoActual.getImagenes()){
            imagenSer.eliminarImagen(imagen);
        }
        arriendoSer.deleteArriendo(arriendoActual);
        return "redirect:/";
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
            return "Posteo.jsp";
        }

        Arriendo arriendoActual = formularioCrear.getArriendoAct();
        
        arriendoActual.setCreador(loginSer.selectPorId(idUsuario));
        arriendoActual.setDireccion(formularioCrear.getDireccionAct());
        arriendoActual.setCaracteristica(formularioCrear.getCaracteristicaAct());

        direccionRep.save(formularioCrear.getDireccionAct());
        caracteristicaRep.save(formularioCrear.getCaracteristicaAct());
        arriendoRep.save(formularioCrear.getArriendoAct());

        if(!imagen.isEmpty()){
            String rutaAbsoluta = "C://Producto//recursos";

            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);

                Imagenes nuevaImagen = new Imagenes();
                nuevaImagen.setArriendo(arriendoActual);
                nuevaImagen.setRutaImagen(imagen.getOriginalFilename());

                imagenesRep.save(nuevaImagen);

            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }

        return "redirect:/";
    }
}
