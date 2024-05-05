package com.chileroomie.chileroomieapp.modelos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "caracteristicas")
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean internet;
    private boolean accesoGas;
    private short habitaciones;
    private short baños;
    private boolean gimnasio;
    private boolean mesaPool;
    private boolean quincho;
    private String descripcion;
    private boolean mascotas;
    private boolean estacionamiento;
    private int gastosComunes;
    @Column(updatable = false)
    private Date creadoEn;
    private Date actualizadoEn;

    @PrePersist public void onCreate() {this.creadoEn = new Date();}
    @PreUpdate public void onUpdate() {this.actualizadoEn = new Date();}

    public Caracteristica() {}
    public void setId(long id) {this.id = id;}
    public long getId() {return id;}
    public void setInternet(boolean internet) {this.internet = internet;}
    public boolean getInternet() {return internet;}
    public void setAccesoGas(boolean accesoGas) {this.accesoGas = accesoGas;}
    public boolean getAccesoGas() {return accesoGas;}
    public void setHabitaciones(short habitaciones) {this.habitaciones = habitaciones;}
    public short getHabitaciones() {return habitaciones;}
    public void setBaños(short baños) {this.baños = baños;}
    public short getBaños() {return baños;}
    public void setGimnasio(boolean gimnasio) {this.gimnasio = gimnasio;}
    public boolean getGimnasio() {return gimnasio;}
    public void setMesaPool(boolean mesaPool) {this.mesaPool = mesaPool;}
    public boolean getMesaPool() {return mesaPool;}
    public void setQuincho(boolean quincho) {this.quincho = quincho;}
    public boolean getQuincho() {return quincho;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public String getDescripcion() {return descripcion;}
    public void setMascotas(boolean mascotas) {this.mascotas = mascotas;}
    public boolean getMascotas() {return mascotas;}
    public void setEstacionamiento(boolean estacionamiento) {this.estacionamiento = estacionamiento;}
    public boolean getEstacionamiento() {return estacionamiento;}
    public void setGastosComunes(int gastosComunes) {this.gastosComunes = gastosComunes;}
    public int getGastosComunes() {return gastosComunes;}
    public Date getCreadoEn() {return creadoEn;}
    public void setActualizadoEn(Date actualizadoEn) {this.actualizadoEn = actualizadoEn;}
    public Date getActualizadoEn() {return actualizadoEn;}
}
