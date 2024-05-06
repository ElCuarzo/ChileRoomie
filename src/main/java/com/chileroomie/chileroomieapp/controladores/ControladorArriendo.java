package com.chileroomie.chileroomieapp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chileroomie.chileroomieapp.modelos.Arriendo;
import com.chileroomie.chileroomieapp.modelos.FormularioCrear;
import com.chileroomie.chileroomieapp.repositorios.ArriendoRepositorio;
import com.chileroomie.chileroomieapp.repositorios.CaracteristicaRepositorio;
import com.chileroomie.chileroomieapp.repositorios.DireccionRepositorio;
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

    @RequestMapping("/crear/posteo")
    public String CrearPosteo(@ModelAttribute("formularioCrear") FormularioCrear formularioCrear){
        return "Posteo.jsp";
    }

    @RequestMapping(value="/procesar/posteo", method= RequestMethod.POST)
    public String ProcesarPosteo(@Valid @ModelAttribute("formularioCrear") FormularioCrear formularioCrear,
                                BindingResult resultadoFormulario, HttpSession sesion)
                                {
        if(resultadoFormulario.hasErrors()){
            System.out.println("oñaError");
            return "Posteo.jsp";
        }

        Long idUsuario = (Long) sesion.getAttribute("idUsuario");

        Arriendo arriendoActual = formularioCrear.getArriendoAct();
        arriendoActual.setCreador(loginSer.selectPorId(idUsuario));
        arriendoActual.setDireccion(formularioCrear.getDireccionAct());
        arriendoActual.setCaracteristica(formularioCrear.getCaracteristicaAct());
        
        direccionRep.save(formularioCrear.getDireccionAct());
        caracteristicaRep.save(formularioCrear.getCaracteristicaAct());
        arriendoRep.save(formularioCrear.getArriendoAct());

        return "vistadespuesdelproceso";
    }
}
