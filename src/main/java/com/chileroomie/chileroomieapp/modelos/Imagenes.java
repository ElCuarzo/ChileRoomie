package com.chileroomie.chileroomieapp.modelos;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagenes")
public class Imagenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rutaImagen;
    private Date creadoEn;
    private Date actualizadoEn;

    @PrePersist public void onCreate(){this.creadoEn = new Date();}
    @PreUpdate public void onUpdate(){this.actualizadoEn = new Date();}

    public Imagenes(){}

    public Imagenes(String rutaImagen){
        this.rutaImagen = rutaImagen;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getCreadoEn() {
        return creadoEn;
    }
    public void setCreadoEn(Date creadoEn) {
        this.creadoEn = creadoEn;
    }
    public Date getActualizadoEn() {
        return actualizadoEn;
    }
    public void setActualizadoEn(Date actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    
}
