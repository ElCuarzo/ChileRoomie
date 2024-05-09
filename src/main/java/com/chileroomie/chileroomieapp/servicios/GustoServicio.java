package com.chileroomie.chileroomieapp.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chileroomie.chileroomieapp.modelos.FormularioUsuario;
import com.chileroomie.chileroomieapp.modelos.Gusto;
import com.chileroomie.chileroomieapp.modelos.Usuario;
import com.chileroomie.chileroomieapp.repositorios.GustoRepositorio;

@Service
public class GustoServicio {
    @Autowired
    private final GustoRepositorio gustoRepositorio;

    public GustoServicio(GustoRepositorio gustoRepositorio){
        this.gustoRepositorio = gustoRepositorio;
    }

    //Guarda el gusto
    public Gusto saveGusto(Gusto gusto){
        return gustoRepositorio.save(gusto);
    }

    //Borra el gusto
    public void deleteGusto(Gusto gusto){
        gustoRepositorio.delete(gusto);
    }

    //Busca el gusto por id
    public Gusto findGustoById(Long gustoId) {
        Optional<Gusto> gustoOptional = gustoRepositorio.findById(gustoId);
        if (gustoOptional.isPresent()) {
            return gustoOptional.get();
        } else {
            // Si no se encuentra ningún gusto con el ID especificado, puedes manejarlo como desees.
            // En este ejemplo, simplemente devolvemos null.
            return null;
        }
    }

    //Toma todos los gustos
    public List<Gusto> findAllGustos(){
        return (List<Gusto>) gustoRepositorio.findAll();
    }

    //Actualizar gusto
    public void updateGusto(Gusto gusto){
        gustoRepositorio.save(gusto);
    }
    
    //Actualizar datos de objeto por objeto ignorando los strings
    public void actualizarGustos(FormularioUsuario formularioUsuario, Usuario usuario) {
    Gusto gusto = usuario.getGustos();
    Gusto gustoActual = formularioUsuario.getGustosAct();
    BeanUtils.copyProperties(gustoActual, gusto, "id", "creadoEn", "actualizadoEn");
    }
}
