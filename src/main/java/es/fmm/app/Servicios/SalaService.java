package es.fmm.app.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fmm.app.Sala;
import es.fmm.app.Repos.*;
@Service
public class SalaService {
    
    private final SalaRepository salaRepository;

    @Autowired
    public SalaService(SalaRepository salaRepository)
    {
        this.salaRepository = salaRepository;
    }

    //guardar Sala
    public Sala createSala(Sala sala)
    {
        return salaRepository.save(sala);
    }

    //obtener sala por id
    public Sala getSalaId(Long id)
    {
        return salaRepository.findById(id).orElse(null);
    }

    //borra sala por id
    public void deleteSala(Long id)
    {
        salaRepository.deleteById(id);
    }

    //obtener todas las salas
    public List<Sala> getAllSalas()
    {
        return salaRepository.findAll();
    }

    //actualizar sala igual que el crear, lo gestiona solo JPA
    public Sala updateSala(Sala sala)
    {
        return salaRepository.save(sala);
    }


}
