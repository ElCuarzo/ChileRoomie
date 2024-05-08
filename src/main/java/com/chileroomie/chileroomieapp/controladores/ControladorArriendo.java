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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chileroomie.chileroomieapp.modelos.Arriendo;
import com.chileroomie.chileroomieapp.modelos.FormularioCrear;
import com.chileroomie.chileroomieapp.modelos.Imagenes;
import com.chileroomie.chileroomieapp.repositorios.ArriendoRepositorio;
import com.chileroomie.chileroomieapp.repositorios.CaracteristicaRepositorio;
import com.chileroomie.chileroomieapp.repositorios.DireccionRepositorio;
import com.chileroomie.chileroomieapp.repositorios.ImagenesRepositorio;
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

    @RequestMapping("/home")
    public String paginDeInicio(Model modelo){
        List<Arriendo> posteos = (List<Arriendo>) arriendoRep.findAll();
        modelo.addAttribute("posteos", posteos);
        return "Home.jsp";
    }

    @RequestMapping("/crear/posteo")
    public String CrearPosteo(@ModelAttribute("formularioCrear") FormularioCrear formularioCrear, HttpSession sesion){
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/home";
        }
        return "Posteo.jsp";
    }

    @RequestMapping(value="/procesar/posteo", method= RequestMethod.POST)
    public String ProcesarPosteo(@Valid @ModelAttribute("formularioCrear") FormularioCrear formularioCrear,
                                BindingResult resultadoFormulario, HttpSession sesion, @RequestParam("file") MultipartFile imagen)
                                {
        Long idUsuario = (Long) sesion.getAttribute("idUsuario");
        if(idUsuario == null){
            return "redirect:/home";
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

        return "redirect:/home";
    }
}
