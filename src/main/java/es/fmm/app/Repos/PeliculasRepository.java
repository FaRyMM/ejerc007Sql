package es.fmm.app.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import es.fmm.app.Peliculas;

public interface PeliculasRepository extends JpaRepository<Peliculas, Long>{
    
}
