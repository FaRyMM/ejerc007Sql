package es.fmm.app;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import es.fmm.app.Controladores.VentasController;
import es.fmm.app.Servicios.VentaService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class VentasControllerTests {

    @MockBean
    private VentaService ventasService;

    @InjectMocks
    private VentasController ventasController;

    private MockMvc mockMvc;

    public VentasControllerTests() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(ventasController).build();
    }

    @Test
    public void testGetVenta() throws Exception {
        Long ventaId = 1L;
        Sala sala = new Sala("sala1", 100);
        Peliculas pelicula = new Peliculas("Una peli", LocalDate.now(), LocalDate.now().plusDays(10), sala);
        Sesion sesion = new Sesion(LocalTime.now(), LocalTime.now().plusHours(3), pelicula);
        Ventas venta = new Ventas(EstadosVenta.Aceptada, 1, 5.00, pelicula, sesion, LocalDate.now());
        venta.setId(ventaId);

        when(ventasService.getVentasId(ventaId)).thenReturn(venta);

        mockMvc.perform(get("/ventas/{id}", ventaId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(ventaId))
                .andExpect(jsonPath("$.cantidad").value(2))
                .andExpect(jsonPath("$.precio").value(5.00));
    }

    @Test
    public void testGetAllVentas() throws Exception {
        Sala sala = new Sala("sala1", 100);
        Peliculas pelicula = new Peliculas("Una peli", LocalDate.now(), LocalDate.now().plusDays(10), sala);
        Sesion sesion = new Sesion(LocalTime.now(), LocalTime.now().plusHours(3), pelicula);
        Ventas venta1 = new Ventas(EstadosVenta.Aceptada, 1, 5.00, pelicula, sesion, LocalDate.now());
        Ventas venta2 = new Ventas(EstadosVenta.Aceptada, 1, 5.00, pelicula, sesion, LocalDate.now());


        List<Ventas> ventasList = Arrays.asList(venta1, venta2);

        when(ventasService.getAllVentas()).thenReturn(ventasList);

        mockMvc.perform(get("/ventas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].cantidad").value(3))
                .andExpect(jsonPath("$[0].precio").value(5.00))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].cantidad").value(5))
                .andExpect(jsonPath("$[1].precio").value(5.00));
    }

    @Test
    public void testCreateVenta() throws Exception {
        Sala sala = new Sala("sala1", 100);
        Peliculas pelicula = new Peliculas("Una peli", LocalDate.now(), LocalDate.now().plusDays(10), sala);
        Sesion sesion = new Sesion(LocalTime.now(), LocalTime.now().plusHours(3), pelicula);
        Ventas venta = new Ventas(null, 0, 5.00, pelicula, sesion, LocalDate.now());

        when(ventasService.createVenta(venta)).thenReturn(venta);

        mockMvc.perform(post("/ventas")
                .contentType("application/json")
                .content("{\"cantidad\": 2, \"precio\": 5.00}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cantidad").value(2))
                .andExpect(jsonPath("$.precio").value(5.00));
    }

    // Agrega más tests para los demás métodos del controlador...

}
