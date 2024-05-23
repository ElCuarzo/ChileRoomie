package com.chileroomie.chileroomieapp.modelos;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "arriendos")
public class Arriendo {

    // TODO: Utilizamos estas variables que se limitaran desde el JSP {DISPONIBLE, ARRENDADO, MANTENCION}
    // Esto para el valor de "tipo_de_arriendo".

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String estadoDeArriendo;
    private boolean amoblado;
    private int precio;
    private String domicilio;
    
    //TODO: mapear la relación
    @ManyToOne
    private Usuario creador;

    @OneToOne
    @JoinColumn(name = "imagenes_id", referencedColumnName = "id")
    private Imagenes imagenes;

    @OneToOne
    @JoinColumn(name = "imagen1_id", referencedColumnName = "id")
    private Imagenes imagen2;
    @OneToOne
    @JoinColumn(name = "imagen2_id", referencedColumnName = "id")
    private Imagenes imagen3;

    @OneToOne   
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;

    @OneToOne
    @JoinColumn(name = "caracteristica_id", referencedColumnName = "id")
    private Caracteristica caracteristica;

    private Date creadoEn;
    private Date actualizadoEn;

    @PrePersist public void onCreate(){this.creadoEn = new Date();}
    @PreUpdate public void onUpdate(){this.actualizadoEn = new Date();}

    public Arriendo(){}

    public long getId(){return id;}
    public void setId(long id){this.id = id;}
    public String getEstadoDeArriendo(){return estadoDeArriendo;}
    public void setEstadoDeArriendo(String tipo_de_arriendo){this.estadoDeArriendo = tipo_de_arriendo;}
    public boolean getAmoblado(){return amoblado;}
    public void setAmoblado(boolean amoblado){this.amoblado = amoblado;}
    public int getPrecio(){return precio;}
    public void setPrecio(int precio){this.precio = precio;}
    public Usuario getCreador(){return creador;}
    public void setCreador(Usuario creador){this.creador = creador;}
    public Direccion getDireccion(){return direccion;}
    public void setDireccion(Direccion direccion){this.direccion = direccion;}
    public Caracteristica getCaracteristica() {return caracteristica;}
    public void setCaracteristica(Caracteristica caracteristica) {this.caracteristica = caracteristica;}
    public Imagenes getImagenes() {return imagenes;}
    public void setImagenes(Imagenes imagenes) {this.imagenes = imagenes;}
    public String getDomicilio(){return domicilio;}
    public void setDomicilio(String Domicilio){this.domicilio = Domicilio;}
    public Imagenes getImagen2() {return imagen2;}
    public void setImagen2(Imagenes imagen2) {this.imagen2 = imagen2;}
    public Imagenes getImagen3() {return imagen3;}
    public void setImagen3(Imagenes imagen3) {this.imagen3 = imagen3;}

    public Date getActualizadoEn(){return actualizadoEn;}
    public void setActualizadoEn(Date actualizadoEn){this.actualizadoEn = actualizadoEn;}
    public Date getCreadoEn() {return creadoEn;}
    public void setCreadoEn(Date creadoEn) {this.creadoEn = creadoEn;}


}
