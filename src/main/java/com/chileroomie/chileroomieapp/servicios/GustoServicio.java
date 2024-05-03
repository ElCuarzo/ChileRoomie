package com.chileroomie.chileroomieapp.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chileroomie.chileroomieapp.modelos.Gusto;
import com.chileroomie.chileroomieapp.repositorios.GustoRepositorio;

@Service
public class GustoServicio {
    @Autowired
    private final GustoRepositorio gustoRepositorio;

    public GustoServicio(GustoRepositorio gustoRepositorio){
        this.gustoRepositorio = gustoRepositorio;
    }

    //Guarda el gusto
    public void saveGusto(Gusto gusto){
        gustoRepositorio.save(gusto);
    }

    //Borra el gusto
    public void deleteGusto(Gusto gusto){
        gustoRepositorio.delete(gusto);
    }

    //Busca el gusto por id
    public Gusto findGustoById(Long id){
        return gustoRepositorio.findById(id).get();
    }

    //Toma todos los gustos
    public List<Gusto> findAllGustos(){
        return (List<Gusto>) gustoRepositorio.findAll();
    }

    //NOTE: tal vez se necesite implementar métodos de búsqueda
}
