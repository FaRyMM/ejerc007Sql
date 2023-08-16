package es.fmm.app;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Peliculas{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private LocalDate inicio;
    private LocalDate fin;
    @ManyToOne
    private Sala sala;
    @OneToMany
    private List<Sesion> sessiones;
    
    public Peliculas() {}

    public Peliculas(String titulo, LocalDate inicio, LocalDate fin, Sala sala) {
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
        this.sala = sala;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public LocalDate getInicio() {
        return inicio;
    }
    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }
    public LocalDate getFin() {
        return fin;
    }
    public void setFin(LocalDate fin) {
        this.fin = fin;
    }
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    public List<Sesion> getSessiones() {
        return sessiones;
    }
    public void setSessiones(List<Sesion> sessiones) {
        this.sessiones = sessiones;
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peliculas peliculas = (Peliculas) o;
        return Objects.equals(id, peliculas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}