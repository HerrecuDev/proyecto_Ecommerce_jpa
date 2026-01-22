package org.iesdm.proyecto_ecommerce_jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesdm.proyecto_ecommerce_jpa.domain.Producto;
import org.iesdm.proyecto_ecommerce_jpa.service.CarritoService;
import org.iesdm.proyecto_ecommerce_jpa.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1/products")
public class ProductoController {

    private final ProductoService productoService;
    private final CarritoService carritoService;

    public ProductoController(ProductoService productoService, CarritoService carritoService) {
        this.productoService = productoService;
        this.carritoService = carritoService;
    }
    //CRUD es Create / Read / Update / Delete


    //Read - Todos los productos:
    @GetMapping
    public ResponseEntity<List<Producto>> findAll(){
        log.info("Listamos todos los productos");
        return ResponseEntity.ok(productoService.findall());
    }

    //CREATED al producto:
    @PostMapping
    public ResponseEntity<Producto> CrearProducto(@RequestBody Producto producto){

        //Creamos el producto
        log.info("Producto Creado :" + producto);
        return ResponseEntity.ok().body(productoService.save(producto));

        //La I.A dice que seria :
        //return ResponseEntity.ok(productoService.save(producto));
    }

    //READ producto segun su id.
    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable Long id){
        Producto producto = productoService.findById(id);
        //Si el producto su valor es NULO:
        if (producto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    //Update (Añadir el producto seleccionado):
    @PutMapping("{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id ,@RequestBody Producto producto){
        Producto existente = productoService.findById(id);

        if (existente == null){
            return ResponseEntity.notFound().build();
        }

        producto.setId(id);

        return ResponseEntity.ok(productoService.save(producto));
    }


    //Delete:
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
