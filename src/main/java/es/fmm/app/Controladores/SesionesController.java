package es.fmm.app.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.fmm.app.Sesion;
import es.fmm.app.Ventas;
import es.fmm.app.Servicios.SessionesService;


@RestController
@RequestMapping("/sesion")
public class SesionesController {

    private final SessionesService sessionServices;

    @Autowired
    public SesionesController(SessionesService sessionServices) {
        this.sessionServices = sessionServices;
    }

}
