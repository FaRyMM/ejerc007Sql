package es.fmm.app.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fmm.app.Peliculas;
import es.fmm.app.Repos.PeliculasRepository;
@Service
public class PeliculaService {

    private final PeliculasRepository peliculaRepository;

    @Autowired
    public PeliculaService(PeliculasRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }
    
    public Peliculas getPeliculaId(Long id)
    {
        return peliculaRepository.findById(id).orElse(null);
    }

    public List<Peliculas> getAllPeliculas()
    {
        return peliculaRepository.findAll();
    }

    public Peliculas createPelicula(Peliculas pelicula)
    {
        return peliculaRepository.save(pelicula);
    }

    public Peliculas updatePelicula(Peliculas pelicula)
    {
        return peliculaRepository.save(pelicula);
    }

    public void deletePelicula(Long id)
    {
        peliculaRepository.deleteById(id);
    }


}
