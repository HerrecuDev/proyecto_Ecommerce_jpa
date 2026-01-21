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

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    //Lista todos los productos:
    public List<Producto> all(){


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

    //Para bsucar los productos mediante su categoria:
    public List<Producto> findByCategoria(Categoria categoria){

        return productoRepository.findByCategoria(categoria);
    }


    //Para eliminar del carrito los productos :


}
