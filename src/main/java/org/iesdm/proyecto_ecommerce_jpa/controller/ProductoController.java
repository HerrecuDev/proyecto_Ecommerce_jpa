package org.iesdm.proyecto_ecommerce_jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesdm.proyecto_ecommerce_jpa.domain.Producto;
import org.iesdm.proyecto_ecommerce_jpa.service.CarritoService;
import org.iesdm.proyecto_ecommerce_jpa.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService productoService;
    private final CarritoService carritoService;

    public ProductoController(ProductoService productoService, CarritoService carritoService) {
        this.productoService = productoService;
        this.carritoService = carritoService;
    }

    //Read - Todos los productos CON FILTROS:
    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(
            @RequestParam(required = false) String buscar,
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamano,
            @RequestParam(defaultValue = "id") String ordenar) {

        log.info("Listamos productos con filtros - buscar: {}, pagina: {}, tamano: {}, ordenar: {}",
                buscar, pagina, tamano, ordenar);

        Page<Producto> page = productoService.findAll(buscar, pagina, tamano, ordenar);

        Map<String, Object> response = Map.of(
                "productos", page.getContent(),
                "paginaActual", page.getNumber(),
                "totalElementos", page.getTotalElements(),
                "totalPaginas", page.getTotalPages(),
                "tamanoPagina", page.getSize()
        );

        return ResponseEntity.ok(response);
    }

    //CREATED al producto:
    @PostMapping
    public ResponseEntity<Producto> CrearProducto(@RequestBody Producto producto){

        //Creamos el producto
        log.info("Producto Creado :" + producto);
        return ResponseEntity.ok().body(productoService.save(producto));

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
