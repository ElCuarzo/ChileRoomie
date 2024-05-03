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
    // TODO: quizás hay que cambiar esto, 
    enum Estado {DISPONIBLE, ARRENDADO, MANTENCION}


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Estado tipo_de_arriendo;
    private boolean amoblado;
    private int precio;
    
    //TODO: mapear la relación
    @ManyToOne
    private Usuario creador;

    @OneToOne   
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;

    //TODO: mapear caracteristicas

    private Date creadoEn;
    private Date actualizadoEn;

    @PrePersist public void onCreate(){this.creadoEn = new Date();}
    @PreUpdate public void onUpdate(){this.actualizadoEn = new Date();}

    public Arriendo(){}
    public Arriendo(Estado tipo_de_arriendo, boolean amoblado, int precio){
        this.tipo_de_arriendo = tipo_de_arriendo;
        this.amoblado = amoblado;
        this.precio = precio;
    }

    public long getId(){return id;}
    public void setId(long id){this.id = id;}
    public Estado getTipo_de_arriendo(){return tipo_de_arriendo;}
    public void setTipo_de_arriendo(Estado tipo_de_arriendo){this.tipo_de_arriendo = tipo_de_arriendo;}
    public boolean getAmoblado(){return amoblado;}
    public void setAmoblado(boolean amoblado){this.amoblado = amoblado;}
    public int getPrecio(){return precio;}
    public void setPrecio(int precio){this.precio = precio;}
    public Usuario getCreador(){return creador;}
    public void setCreador(Usuario creador){this.creador = creador;}
    public Direccion getDireccion(){return direccion;}
    public void setDireccion(Direccion direccion){this.direccion = direccion;}

    public Date getCreadoEn(){return creadoEn;}
    public Date getActualizadoEn(){return actualizadoEn;}
    public void setActualizadoEn(Date actualizadoEn){this.actualizadoEn = actualizadoEn;}
}
