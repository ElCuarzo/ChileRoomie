package com.chileroomie.chileroomieapp.modelos;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    //Data del usuario
    //TODO: quizás esto tiene que ser not blank pero para probar el login lo dejaré así por mientras
    //NOTE: string porque quizas quiere poner un genero random como no binarie o fox/self no se
    private String genero;
    //TODO: quizas queremos tener una lista de universidades y tener la universidadd como entidad separada.
    private String universidad;
    private String telefono;

    @OneToOne
    private Direccion direccion;

    @OneToOne
    private Gusto gustos;

    @OneToMany(mappedBy = "creador")
    private List<Arriendo> arriendos;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creadoEn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date actualizadoEn;

    //TODO: FOTOS


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

    public Date getActualizadoEn() {
        return actualizadoEn;
    }

    public void setActualizadoEn(Date actualizadoEn) {
        this.actualizadoEn = actualizadoEn;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Gusto getGustos() {
        return gustos;
    }

    public void setGustos(Gusto gustos) {
        this.gustos = gustos;
    }

    public List<Arriendo> getArriendos() {
        return arriendos;
    }

    public void setArriendos(List<Arriendo> arriendos) {
        this.arriendos = arriendos;
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
