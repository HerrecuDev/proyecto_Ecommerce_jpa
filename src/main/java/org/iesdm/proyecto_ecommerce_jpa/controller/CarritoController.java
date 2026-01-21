package org.iesdm.proyecto_ecommerce_jpa.controller;

import org.iesdm.proyecto_ecommerce_jpa.domain.Carrito;
import org.iesdm.proyecto_ecommerce_jpa.service.CarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/v2/carrito")
public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @PostMapping("/add")
    public ResponseEntity<Carrito> addToCarrito (@RequestParam Long usuarioId ,
                                                 @RequestParam Long productoId ,
                                                 @RequestParam BigDecimal cantidad){

        Carrito carrito = carritoService.addToCarrito(usuarioId,productoId,cantidad);
        return ResponseEntity.ok(carrito);


    }
}
