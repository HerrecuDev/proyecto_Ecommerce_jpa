package org.iesdm.proyecto_ecommerce_jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesdm.proyecto_ecommerce_jpa.dto.CarritoDTO;
import org.iesdm.proyecto_ecommerce_jpa.service.CarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("api/v2/carrito")
public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @PostMapping("/add")
    public ResponseEntity<CarritoDTO> addToCarrito (@RequestParam Long usuarioId ,
                                                     @RequestParam Long productoId ,
                                                     @RequestParam BigDecimal cantidad){

        log.info("Añadiendo al carrito - usuarioId: {}, productoId: {}, cantidad: {}",
                usuarioId, productoId, cantidad);

        // Primero guardamos el producto en el carrito
        carritoService.addToCarrito(usuarioId, productoId, cantidad);

        // Luego obtenemos el carrito completo con el total
        CarritoDTO response = carritoService.getCarritoConTotal(usuarioId);

        return ResponseEntity.ok(response);
    }
}
