package com.chileroomie.chileroomieapp.modelos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min = 3, message = "Por favor proporciona tú nombre")
    private String nombre;
    private String correo;
    @Size(min = 1, message = "Por favor proporciona tu contraseña")
    private String contrasena;
    @Transient
    private String confirmacionContrasena;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creadoEn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date actualizadoEn;

    // Espacio para asignar la relación

    public Usuario() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getConfirmacionContrasena() {
        return confirmacionContrasena;
    }

    public void setConfirmacionContrasena(String confirmacionContrasena) {
        this.confirmacionContrasena = confirmacionContrasena;
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

    @PrePersist
    protected void onCreate() {
        this.creadoEn = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.actualizadoEn = new Date();
    }
}
