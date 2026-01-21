package org.iesdm.proyecto_ecommerce_jpa.service;

import org.iesdm.proyecto_ecommerce_jpa.domain.Producto;
import org.iesdm.proyecto_ecommerce_jpa.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> all(){


        return productoRepository.findAll();
    }

    public Producto save(Producto producto){
        return  productoRepository.save(producto);
    }
}
