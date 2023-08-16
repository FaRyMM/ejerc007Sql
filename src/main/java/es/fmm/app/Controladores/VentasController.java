package es.fmm.app.Controladores;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.fmm.app.Ventas;
import es.fmm.app.Servicios.VentaService;

@RestController
@RequestMapping("/ventas")
public class VentasController {

    private final VentaService ventasService;

    @Autowired
    public VentasController(VentaService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping("/{id}")
    public Ventas getVenta(@PathVariable Long id) {
        return ventasService.getVentasId(id);
    }

    @GetMapping
    public List<Ventas> getAllVentas() {
        return ventasService.getAllVentas();
    }

    @PostMapping
    public Ventas createVenta(@RequestBody Ventas venta) {
        return ventasService.createVenta(venta);
    }

    @PutMapping
    public Ventas updateVenta(@RequestBody Ventas venta) {
        return ventasService.updateVenta(venta);
    }

    @DeleteMapping("/{id}")
    public void deleteVenta(@PathVariable Long id) {
        ventasService.deleteVentas(id);
    }
}
