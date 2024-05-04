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
    //TODO: string por si quiere darle detalles de velocidad o cosas?
    private String internet;
    private boolean acceso_gas;
    private short habitaciones;
    private short baños;
    private boolean gimnasio;
    private String mesa_pool;
    private String quincho;
    private String descripcion;
    private boolean mascotas;
    private String descripcion_mascotas;
    private boolean estacionamiento;
    private int gastos_comunes;
    @Column(updatable = false)
    private Date creadoEn;
    private Date actualizadoEn;

    @PrePersist public void onCreate() {this.creadoEn = new Date();}
    @PreUpdate public void onUpdate() {this.actualizadoEn = new Date();}

    public Caracteristica() {}
    public void setId(long id) {this.id = id;}
    public long getId() {return id;}
    public void setInternet(String internet) {this.internet = internet;}
    public String getInternet() {return internet;}
    public void setAcceso_gas(boolean acceso_gas) {this.acceso_gas = acceso_gas;}
    public boolean getAcceso_gas() {return acceso_gas;}
    public void setHabitaciones(short habitaciones) {this.habitaciones = habitaciones;}
    public short getHabitaciones() {return habitaciones;}
    public void setBaños(short baños) {this.baños = baños;}
    public short getBaños() {return baños;}
    public void setGimnasio(boolean gimnasio) {this.gimnasio = gimnasio;}
    public boolean getGimnasio() {return gimnasio;}
    public void setMesa_pool(String mesa_pool) {this.mesa_pool = mesa_pool;}
    public String getMesa_pool() {return mesa_pool;}
    public void setQuincho(String quincho) {this.quincho = quincho;}
    public String getQuincho() {return quincho;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public String getDescripcion() {return descripcion;}
    public void setMascotas(boolean mascotas) {this.mascotas = mascotas;}
    public boolean getMascotas() {return mascotas;}
    public void setDescripcion_mascotas(String descripcion_mascotas) {this.descripcion_mascotas = descripcion_mascotas;}
    public String getDescripcion_mascotas() {return descripcion_mascotas;}
    public void setEstacionamiento(boolean estacionamiento) {this.estacionamiento = estacionamiento;}
    public boolean getEstacionamiento() {return estacionamiento;}
    public void setGastos_comunes(int gastos_comunes) {this.gastos_comunes = gastos_comunes;}
    public int getGastos_comunes() {return gastos_comunes;}
    public Date getCreadoEn() {return creadoEn;}
    public void setActualizadoEn(Date actualizadoEn) {this.actualizadoEn = actualizadoEn;}
    public Date getActualizadoEn() {return actualizadoEn;}
}
