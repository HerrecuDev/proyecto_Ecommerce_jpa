package org.iesdm.proyecto_ecommerce_jpa.service;

import org.iesdm.proyecto_ecommerce_jpa.domain.Categoria;
import org.iesdm.proyecto_ecommerce_jpa.domain.Producto;
import org.iesdm.proyecto_ecommerce_jpa.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CarritoService carritoService;

    public ProductoService(ProductoRepository productoRepository, CarritoService carritoService) {
        this.productoRepository = productoRepository;
        this.carritoService = carritoService;
    }


    //Lista todos los productos:
    public List<Producto> findall(){


        return productoRepository.findAll();
    }
    // Guardamos los productos
    public Producto save(Producto producto){
        return  productoRepository.save(producto);
    }

    // Para buscar los productos mediante su id
    public Producto findById(Long id){

        return productoRepository.findById(id).orElse(null);
    }

    //Para buscar los productos mediante su categoria:
    public List<Producto> findByCategoria(Categoria categoria){
        return productoRepository.findByCategoria(categoria);
    }

    //Delete:
    public void delete(Long id){
        productoRepository.deleteById(id);
    }



}
