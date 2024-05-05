package com.chileroomie.chileroomieapp.modelos;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "direcciones")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Por favor proporciona una dirección")
    private String direccion;
    @NotBlank(message = "Por favor proporciona una ciudad")
    private String ciudad;
    @NotBlank(message = "Por favor proporciona una comuna")
    private String comuna;

    // Espacio para asignar la relación

    private Date creadoEn;
    private Date actualizadoEn;

    @PrePersist protected void onCreate(){this.creadoEn = new Date();}
    @PreUpdate protected void onUpdate(){this.actualizadoEn = new Date();}

    public Direccion(){}
    public Direccion(String direccion, String ciudad, String comuna){
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.comuna = comuna;
    }

    public long getId(){return id;}
    public void setId(long id){this.id = id;}
    public String getDireccion(){return direccion;}
    public void setDireccion(String direccion){this.direccion = direccion;} 
    public String getCiudad(){return ciudad;}
    public void setCiudad(String ciudad){this.ciudad = ciudad;}
    public String getComuna(){return comuna;}
    public void setComuna(String comuna){this.comuna = comuna;}
    public Date getCreadoEn(){return creadoEn;}
    public Date getActualizadoEn(){return actualizadoEn;}
    public void setActualizadoEn(Date actualizadoEn){this.actualizadoEn = actualizadoEn;}
}
