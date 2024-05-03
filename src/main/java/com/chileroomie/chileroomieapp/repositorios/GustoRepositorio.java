package com.chileroomie.chileroomieapp.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chileroomie.chileroomieapp.modelos.Gusto;

@Repository
public interface GustoRepositorio extends CrudRepository<Gusto, Long>{
    
}
