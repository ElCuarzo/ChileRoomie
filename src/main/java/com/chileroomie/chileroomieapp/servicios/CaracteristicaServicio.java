package com.chileroomie.chileroomieapp.servicios;

import org.springframework.stereotype.Service;

import com.chileroomie.chileroomieapp.modelos.Caracteristica;
import com.chileroomie.chileroomieapp.repositorios.CaracteristicaRepositorio;

@Service
public class CaracteristicaServicio {
    //TODO: esto quizas no sea necesario porque no se manejan caracteristicas por separado sino que a traves del arriendo
    private final CaracteristicaRepositorio caracteristicaRepositorio;

    public CaracteristicaServicio(CaracteristicaRepositorio caracteristicaRepositorio){
        this.caracteristicaRepositorio = caracteristicaRepositorio;
    }

    //Guarda la caracteristica
    public void saveCaracteristica(Caracteristica caracteristica){
        caracteristicaRepositorio.save(caracteristica);
    }

    //Borra la caracteristica
    public void deleteCaracteristica(Caracteristica caracteristica){
        caracteristicaRepositorio.delete(caracteristica);
    }
}
