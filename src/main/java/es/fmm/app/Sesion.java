package es.fmm.app;


import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sesion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime Inicio;
    private LocalTime Fin;
    @ManyToOne
    private Peliculas pelicula;
    
    public Sesion() {}

    public Sesion(LocalTime inicio, LocalTime fin, Peliculas pelicula) {
        this.Inicio = inicio;
        this.Fin = fin;
        this.pelicula = pelicula;
    }

    public Long getId() {
        return id;
    }
    public Peliculas getPelicula() {
        return pelicula;
    }
    public void setPelicula(Peliculas pelicula) {
        this.pelicula = pelicula;
    }
    public LocalTime getInicio() {
        return Inicio;
    }
    public void setInicio(LocalTime inicio) {
        Inicio = inicio;
    }
    public LocalTime getFin() {
        return Fin;
    }
    public void setFin(LocalTime fin) {
        Fin = fin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sesion sesion = (Sesion) o;
        return Objects.equals(id, sesion.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}