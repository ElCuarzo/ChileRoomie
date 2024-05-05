package com.chileroomie.chileroomieapp.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chileroomie.chileroomieapp.modelos.Arriendo;
import com.chileroomie.chileroomieapp.modelos.Caracteristica;
import com.chileroomie.chileroomieapp.modelos.Direccion;

@Controller
public class ControladorArriendo {
    
    @RequestMapping("/crear/posteo")
    public String CrearPosteo(Model model){
        Arriendo arriendo = new Arriendo();
        Direccion direccion = new Direccion();
        Caracteristica caracteristica = new Caracteristica();
        
        model.addAttribute("arriendo", arriendo);
        model.addAttribute("direccion", direccion);
        model.addAttribute("caracteristica", caracteristica);
        return "Posteo.jsp";
    }

    @RequestMapping(value="/procesar/posteo", method= RequestMethod.POST)
    public String ProcesarPosteo(){
        return "vistadespuesdelproceso";
    }
}
