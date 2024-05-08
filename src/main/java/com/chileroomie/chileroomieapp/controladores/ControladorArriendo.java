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
import com.chileroomie.chileroomieapp.modelos.FormularioCrear;
import com.chileroomie.chileroomieapp.modelos.Imagenes;
import com.chileroomie.chileroomieapp.modelos.Usuario;
import com.chileroomie.chileroomieapp.repositorios.ArriendoRepositorio;
import com.chileroomie.chileroomieapp.repositorios.CaracteristicaRepositorio;
import com.chileroomie.chileroomieapp.repositorios.DireccionRepositorio;
import com.chileroomie.chileroomieapp.repositorios.ImagenesRepositorio;
import com.chileroomie.chileroomieapp.servicios.ArriendoServicio;
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
    private CaracteristicaRepositorio caracteristicaRep;

    @Autowired
    private LoginServicio loginSer;

    @Autowired
    private ImagenesRepositorio imagenesRep;

    @Autowired
    private ArriendoServicio arriendoSer;

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
    public String editarPerfil(@PathVariable ("id") Long idUsuarioPerfil,
                            Model modelo, HttpSession sesion){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/";
        }

        Usuario usuario = loginSer.selectPorId(idUsuario);
        modelo.addAttribute("usuario", usuario);
        return "EditarPerfilUsuario.jsp";
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
            Path directorioImagenes = Paths.get("src//main//resources//static//images");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

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
