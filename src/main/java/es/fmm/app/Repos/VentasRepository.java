package es.fmm.app.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import es.fmm.app.Ventas;

public interface VentasRepository extends JpaRepository<Ventas, Long> {
    
}
