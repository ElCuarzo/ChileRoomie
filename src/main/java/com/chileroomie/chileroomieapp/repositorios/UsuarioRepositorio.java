package com.chileroomie.chileroomieapp.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chileroomie.chileroomieapp.modelos.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{
    @Override
    List<Usuario> findAll();
    Usuario getByCorreo(String correo);
    Usuario getById(Long id);
}
