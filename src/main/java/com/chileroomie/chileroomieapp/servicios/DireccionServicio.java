package com.chileroomie.chileroomieapp.servicios;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chileroomie.chileroomieapp.modelos.Direccion;
import com.chileroomie.chileroomieapp.modelos.FormularioUsuario;
import com.chileroomie.chileroomieapp.modelos.Usuario;
import com.chileroomie.chileroomieapp.repositorios.DireccionRepositorio;

@Service
public class DireccionServicio {
    @Autowired
    private final DireccionRepositorio direccionRepositorio;

    public DireccionServicio(DireccionRepositorio direccionRepositorio){
        this.direccionRepositorio = direccionRepositorio;
    }

    //Guarda la dirección
    public void saveDireccion(Direccion direccion){
        direccionRepositorio.save(direccion);
    }

    //Borra la dirección
    public void deleteDireccion(Direccion direccion){
        direccionRepositorio.delete(direccion);
    }

    //Busca la dirección por id
    public Direccion findDireccionById(Long id){
        return direccionRepositorio.findById(id).get();
    }

    //Toma todas las direcciones
    public List<Direccion> findAllDirecciones(){
        return (List<Direccion>) direccionRepositorio.findAll();
    }

    //Actualizar dirección
    public void updateDireccion(Direccion direccion){
        direccionRepositorio.save(direccion);
    }

    //Actualizar datos de objeto por objeto ignorando los strings
    public void actualizarGustos(FormularioUsuario formularioUsuario, Usuario usuario) {
    Direccion direccion = usuario.getDireccion();
    Direccion direccionActual = formularioUsuario.getDireccionAct();
    BeanUtils.copyProperties(direccionActual, direccion, "id", "creadoEn", "actualizadoEn");
    }
}
