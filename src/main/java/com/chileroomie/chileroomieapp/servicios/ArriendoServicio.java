package com.chileroomie.chileroomieapp.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chileroomie.chileroomieapp.modelos.Arriendo;
import com.chileroomie.chileroomieapp.repositorios.ArriendoRepositorio;

@Service
public class ArriendoServicio {
    ArriendoRepositorio arriendoRepositorio;

    public ArriendoServicio(ArriendoRepositorio arriendoRepositorio){
        this.arriendoRepositorio = arriendoRepositorio;
    }

    public void saveArriendo(Arriendo arriendo){
        arriendoRepositorio.save(arriendo);
    }

    public void deleteArriendo(Arriendo arriendo){
        arriendoRepositorio.delete(arriendo);
    }

    public Arriendo findArriendoById(Long id){
        return arriendoRepositorio.findById(id).get();
    }

    public List<Arriendo> findAllArriendos(){
        return (List<Arriendo>) arriendoRepositorio.findAll();
    }

    //TODO: implementar métodos de búsqueda
}
