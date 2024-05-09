package com.chileroomie.chileroomieapp.modelos;

import org.springframework.beans.factory.annotation.Autowired;

public class FormularioUsuario {
    @Autowired
    private Usuario usuarioAct;

    @Autowired
    private Gusto gustosAct;

    @Autowired
    private Imagenes imagenenAct;

    @Autowired
    private Direccion direccionAct;

    public Usuario getUsuarioAct() {
        return usuarioAct;
    }

    public void setUsuarioAct(Usuario usuarioAct) {
        this.usuarioAct = usuarioAct;
    }

    public Gusto getGustosAct() {
        return gustosAct;
    }

    public void setGustosAct(Gusto gustosAct) {
        this.gustosAct = gustosAct;
    }

    public Imagenes getImagenenAct() {
        return imagenenAct;
    }

    public void setImagenenAct(Imagenes imagenenAct) {
        this.imagenenAct = imagenenAct;
    }

    public Direccion getDireccionAct() {
        return direccionAct;
    }

    public void setDireccionAct(Direccion direccionAct) {
        this.direccionAct = direccionAct;
    }
}
