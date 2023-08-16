package es.fmm.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.cglib.core.Local;

@Entity
public class Ventas{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private EstadosVenta estadosVenta;
    private int cantidad;
    private Double precio;
    private Double Descuento;
    private Double total;
    private LocalDate fechaVenta;
    @ManyToOne
    private Peliculas pelicula;
    @ManyToOne
    private Sesion session;
    
    public Ventas() {}

    public Ventas(EstadosVenta estado, int cantidad, Double precio, Peliculas pelicula, Sesion session, LocalDate fechaventa)
    {
        this.estadosVenta = estado;
        this.cantidad = cantidad;
        this.fechaVenta = fechaventa;
        this.pelicula = pelicula;
        this.session = session;
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

    public Sesion getSession() {
        return session;
    }

    public void setSession(Sesion session) {
        this.session = session;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Double getDescuento() {
        return Descuento;
    }
    public void setDescuento(Double descuento) {
        Descuento = descuento;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public LocalDate getFechaVenta() {
        return fechaVenta;
    }
    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public EstadosVenta getEstadosVenta() {
        return estadosVenta;
    }
    public void setEstadosVenta(EstadosVenta estadosVenta) {
        this.estadosVenta = estadosVenta;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ventas ventas = (Ventas) o;
        return Objects.equals(id, ventas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}