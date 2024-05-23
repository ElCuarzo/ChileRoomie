package com.chileroomie.chileroomieapp.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chileroomie.chileroomieapp.modelos.Imagenes;
import com.chileroomie.chileroomieapp.repositorios.ImagenesRepositorio;

@Service
public class ImagenesServicio {
    
    @Autowired
    private ImagenesRepositorio imagenesRepositorio;

    //Guarda la imagen
    public void guardarImagen(Imagenes imagenes){
        if(imagenes != null)
            imagenesRepositorio.save(imagenes);
    }

    //Boorra la imagen
    public void eliminarImagen(Imagenes imagenes){
        imagenesRepositorio.delete(imagenes);
    }

    //Busca la imagen por id
    public Imagenes findImagenById(Long id){
        return imagenesRepositorio.findById(id).get();
    }

    //Toma todas las imagenes
    public List<Imagenes> findAllImagenes(){
        return (List<Imagenes>) imagenesRepositorio.findAll();
    }

    //Actualizar las imagenes
    public void actualizarImagenes(Imagenes imagenes){
        imagenesRepositorio.save(imagenes);
    }
}
