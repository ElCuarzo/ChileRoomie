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
@Table(name = "gustos")
public class Gusto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean fumador;
    private boolean lgtv_friendly;
    //TODO: quizas queremos tener una lista de mascotas(?).
    private String mascotas;
    private String signo;
    private int hijos;
    private boolean anime;
    private boolean musica;
    private boolean deporte;
    private boolean lectura;
    private boolean peliculas;
    private boolean series;
    private boolean videojuegos;
    private boolean cocina;
    private boolean arte;
    private boolean viajes;
    private boolean fiestas;
    @Column(updatable = false)
    private Date creadoEn;
    private Date actualizadoEn;

    @PrePersist public void onCreate(){this.creadoEn = new Date();}
    @PreUpdate public void onUpdate(){this.actualizadoEn = new Date();}

    public Gusto(){}

    //TODO: no creo que sea necesario el constructor con todos los atributos, me rehuso a ponerlo

    public long getId(){return id;}
    public void setId(long id){this.id = id;}
    public boolean getFumador(){return fumador;}
    public void setFumador(boolean fumador){this.fumador = fumador;}
    public boolean getLgtv_friendly(){return lgtv_friendly;}
    public void setLgtv_friendly(boolean lgtv_friendly){this.lgtv_friendly = lgtv_friendly;}
    public String getMascotas(){return mascotas;}
    public void setMascotas(String mascotas){this.mascotas = mascotas;}
    public String getSigno(){return signo;}
    public void setSigno(String signo){this.signo = signo;}
    public int getHijos(){return hijos;}
    public void setHijos(int hijos){this.hijos = hijos;}
    public boolean getAnime(){return anime;}
    public void setAnime(boolean anime){this.anime = anime;}
    public boolean getMusica(){return musica;}
    public void setMusica(boolean musica){this.musica = musica;}
    public boolean getDeporte(){return deporte;}
    public void setDeporte(boolean deporte){this.deporte = deporte;}
    public boolean getLectura(){return lectura;}
    public void setLectura(boolean lectura){this.lectura = lectura;}
    public boolean getPeliculas(){return peliculas;}
    public void setPeliculas(boolean peliculas){this.peliculas = peliculas;}
    public boolean getSeries(){return series;}
    public void setSeries(boolean series){this.series = series;}
    public boolean getVideojuegos(){return videojuegos;}
    public void setVideojuegos(boolean videojuegos){this.videojuegos = videojuegos;}
    public boolean getCocina(){return cocina;}
    public void setCocina(boolean cocina){this.cocina = cocina;}
    public boolean getArte(){return arte;}
    public void setArte(boolean arte){this.arte = arte;}
    public boolean getViajes(){return viajes;}
    public void setViajes(boolean viajes){this.viajes = viajes;}
    public boolean getFiestas(){return fiestas;}
    public void setFiestas(boolean fiestas){this.fiestas = fiestas;}
    public Date getCreadoEn(){return creadoEn;}
    public Date getActualizadoEn(){return actualizadoEn;}
    public void setActualizadoEn(Date actualizadoEn){this.actualizadoEn = actualizadoEn;}
    
}
