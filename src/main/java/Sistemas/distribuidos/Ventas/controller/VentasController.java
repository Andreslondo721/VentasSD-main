package Sistemas.distribuidos.Ventas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Sistemas.distribuidos.Ventas.model.Ventas;
import Sistemas.distribuidos.Ventas.service.VentasService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @PostMapping
    public ResponseEntity<Ventas> addVentas(
            @RequestParam String codigo_producto,
            @RequestParam int cantidad,
            @RequestParam String NIT_cliente) {
        
    	Ventas nuevaVenta = new Ventas(codigo_producto, cantidad, NIT_cliente);
    	Ventas guardado = ventasService.createVentas(nuevaVenta);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @GetMapping
    public ResponseEntity<List<Ventas>> getAllVentass() {
        List<Ventas> ventass = ventasService.getAll();
        if (ventass.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(ventass);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ventas> getVentasById(@PathVariable Integer id) {
        return ventasService.getVentasById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ventas> updateVenta(
    		@RequestParam int id,
            @RequestParam String codigo_producto,
            @RequestParam int cantidad,
            @RequestParam String NIT_cliente) {

        if (!ventasService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Ventas ventasActualizada = new Ventas(codigo_producto, cantidad, NIT_cliente);
        ventasActualizada.setId(id);
        Ventas actualizado = ventasService.updateVentas(ventasActualizada);     
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClienteVO(@PathVariable Integer id) {
        if (!ventasService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
        ventasService.deleteVentas(id);
        return ResponseEntity.ok("Venta eliminada exitosamente");
    }
}
