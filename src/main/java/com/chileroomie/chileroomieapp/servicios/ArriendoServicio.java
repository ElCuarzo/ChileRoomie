package com.chileroomie.chileroomieapp.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chileroomie.chileroomieapp.modelos.Arriendo;
import com.chileroomie.chileroomieapp.repositorios.ArriendoRepositorio;

@Service
public class ArriendoServicio {
    @Autowired
    private final ArriendoRepositorio arriendoRepositorio;

    public ArriendoServicio(ArriendoRepositorio arriendoRepositorio){
        this.arriendoRepositorio = arriendoRepositorio;
    }

    //Guarda el arriedno
    public void saveArriendo(Arriendo arriendo){
        arriendoRepositorio.save(arriendo);
    }

    //Boorra el arriendo
    public void deleteArriendo(Arriendo arriendo){
        arriendoRepositorio.delete(arriendo);
    }

    //Busca el arriendo por id
    public Arriendo findArriendoById(Long id){
        return arriendoRepositorio.findById(id).get();
    }

    //Toma todos los arriendos
    public List<Arriendo> findAllArriendos(){
        return (List<Arriendo>) arriendoRepositorio.findAll();
    }

    //TODO: implementar métodos de búsqueda
}
