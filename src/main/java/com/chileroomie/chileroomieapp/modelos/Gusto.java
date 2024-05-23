package com.chileroomie.chileroomieapp.modelos;

import java.util.ArrayList;
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
    private boolean mascotas;
    private String signo;
    private boolean hijos;
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
    public boolean getMascotas(){return mascotas;}
    public void setMascotas(boolean mascotas){this.mascotas = mascotas;}
    public String getSigno(){return signo;}
    public void setSigno(String signo){this.signo = signo;}
    public boolean getHijos(){return hijos;}
    public void setHijos(boolean hijos){this.hijos = hijos;}
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
    
    public ArrayList<String> getGustosArray() {
        ArrayList<String> gustosArray = new ArrayList<String>();
        if(fumador) gustosArray.add("Fuma");
        if(lgtv_friendly) gustosArray.add("LGTV Friendly"); else gustosArray.add("No es lgtv (basado)");
        if(mascotas) gustosArray.add("Le gustan las mascotas");
        gustosArray.add("Signo: " + signo);
        if(hijos) gustosArray.add("Tiene hijos");
        if(anime) gustosArray.add("Le gusta el anime");
        if(musica) gustosArray.add("Le gusta la música");
        if(deporte) gustosArray.add("Le gusta el deporte");
        if(lectura) gustosArray.add("Le gusta la lectura");
        if(peliculas) gustosArray.add("Le gustan las películas");
        if(series) gustosArray.add("Le gustan las series");
        if(videojuegos) gustosArray.add("Le gustan los videojuegos");
        if(cocina) gustosArray.add("Le gusta cocinar");
        if(arte) gustosArray.add("Le gusta el arte");
        if(viajes) gustosArray.add("Le gustan los viajes");
        if(fiestas) gustosArray.add("Le gustan las fiestas");
        return gustosArray;
    }

}
