package com.chileroomie.chileroomieapp.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chileroomie.chileroomieapp.modelos.Direccion;

@Repository
public interface DireccionRepositorio extends CrudRepository<Direccion, Long>{
    
}
