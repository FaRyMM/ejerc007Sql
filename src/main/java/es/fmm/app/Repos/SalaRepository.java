package es.fmm.app.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import es.fmm.app.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    
}
