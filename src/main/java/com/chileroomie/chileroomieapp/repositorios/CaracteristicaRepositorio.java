package com.chileroomie.chileroomieapp.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chileroomie.chileroomieapp.modelos.Caracteristica;

@Repository
public interface CaracteristicaRepositorio extends CrudRepository<Caracteristica, Long>{
    
}
