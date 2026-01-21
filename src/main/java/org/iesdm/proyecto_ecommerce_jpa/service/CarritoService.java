package org.iesdm.proyecto_ecommerce_jpa.service;

import org.iesdm.proyecto_ecommerce_jpa.domain.Carrito;
import org.iesdm.proyecto_ecommerce_jpa.repository.CarritoRepository;
import org.iesdm.proyecto_ecommerce_jpa.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;

    public CarritoService(CarritoRepository carritoRepository, ProductoRepository productoRepository) {
        this.carritoRepository = carritoRepository;
        this.productoRepository = productoRepository;
    }

    //Guardamos los productos en el carrito:
    public Carrito save(Carrito carrito){
        return carritoRepository.save(carrito);
    }

    //Borrar algun producto del carrito
    public void delete(Carrito carrito){

        carritoRepository.delete(carrito);
    }
}
