package es.fmm.app.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.fmm.app.Sala;
import es.fmm.app.Servicios.SalaService;

@RestController
@RequestMapping("/salas")
public class SalasController {

    private final SalaService salasService;

    @Autowired
    public SalasController(SalaService salasService) {
        this.salasService = salasService;
    }

    @GetMapping("/{id}")
    public Sala getSala(@PathVariable Long id) {
        return salasService.getSalaId(id);
    }

    @GetMapping
    public List<Sala> getAllSalas() {
        return salasService.getAllSalas();
    }

    @PostMapping
    public Sala createSala(@RequestBody Sala sala) {
        return salasService.createSala(sala);
    }

    @PutMapping
    public Sala updateSala(@RequestBody Sala sala) {
        return salasService.updateSala(sala);
    }

    @DeleteMapping("/{id}")
    public void deleteSala(@PathVariable Long id) {
        salasService.deleteSala(id);
    }
}
