package org.iesdm.proyecto_ecommerce_jpa.controller;

import org.iesdm.proyecto_ecommerce_jpa.domain.Producto;
import org.iesdm.proyecto_ecommerce_jpa.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    //CRUD es Crear REead Update Delete


    //Para tener mas control:
    @GetMapping
    public ResponseEntity<List<Producto>> findAll(){

        return ResponseEntity.status(204).body(productoService.all());
    }


    //Create:
    @PostMapping
    //@RequstBody convierte el body JSON de lapeticion HTTP a objeto
    public ResponseEntity<Producto> add(@RequestBody Producto producto){

        return  ResponseEntity.ok().body(productoService.save(producto));
    }


}
