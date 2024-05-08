package com.chileroomie.chileroomieapp.modelos;

import org.springframework.beans.factory.annotation.Autowired;

public class FormularioCrear {
    @Autowired
    private Arriendo arriendoAct;

    @Autowired
    private Direccion direccionAct;

    @Autowired
    private Caracteristica caracteristicaAct;

    @Autowired
    private Imagenes imagenesAct;

    public Arriendo getArriendoAct() {
        return arriendoAct;
    }

    public void setArriendoAct(Arriendo arriendoAct) {
        this.arriendoAct = arriendoAct;
    }

    public Direccion getDireccionAct() {
        return direccionAct;
    }

    public void setDireccionAct(Direccion direccionAct) {
        this.direccionAct = direccionAct;
    }

    public Caracteristica getCaracteristicaAct() {
        return caracteristicaAct;
    }

    public void setCaracteristicaAct(Caracteristica caracteristicaAct) {
        this.caracteristicaAct = caracteristicaAct;
    }

    public Imagenes getImagenesAct() {
        return imagenesAct;
    }

    public void setImagenesAct(Imagenes imagenesAct) {
        this.imagenesAct = imagenesAct;
    }
}
