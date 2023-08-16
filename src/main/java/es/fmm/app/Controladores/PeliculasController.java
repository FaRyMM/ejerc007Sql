package es.fmm.app.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.fmm.app.Peliculas;
import es.fmm.app.Servicios.PeliculaService;

@RestController
@RequestMapping("/peliculas")
public class PeliculasController {

    private final PeliculaService peliculasService;

    @Autowired
    public PeliculasController(PeliculaService peliculasService) {
        this.peliculasService = peliculasService;
    }

    @GetMapping("/{id}")
    public Peliculas getPelicula(@PathVariable Long id) {
        return peliculasService.getPeliculaId(id);
    }

    @GetMapping
    public List<Peliculas> getAllPeliculas() {
        return peliculasService.getAllPeliculas();
    }

    @PostMapping
    public Peliculas createPelicula(@RequestBody Peliculas pelicula) {
        return peliculasService.createPelicula(pelicula);
    }

    @PutMapping
    public Peliculas updatePelicula(@RequestBody Peliculas pelicula) {
        return peliculasService.updatePelicula(pelicula);
    }

    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable Long id) {
        peliculasService.deletePelicula(id);
    }
}
