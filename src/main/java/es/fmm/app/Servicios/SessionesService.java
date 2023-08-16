package es.fmm.app.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fmm.app.Sesion;
import es.fmm.app.Repos.SessionesRepository;
@Service
public class SessionesService {
      private final SessionesRepository sessionRepository;

    @Autowired
    public SessionesService(SessionesRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }
    
    public Sesion getSessionId(Long id)
    {
        return sessionRepository.findById(id).orElse(null);
    }
    public List<Sesion> getAllPeliculas()
    {
        return sessionRepository.findAll();
    }

    public Sesion createPelicula(Sesion session)
    {
        return sessionRepository.save(session);
    }

    public Sesion updatePelicula(Sesion session)
    {
        return sessionRepository.save(session);
    }

    public void deletePelicula(Long id)
    {
        sessionRepository.deleteById(id);
    }

}
