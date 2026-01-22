package org.iesdm.proyecto_ecommerce_jpa.service;

import jakarta.transaction.Transactional;
import org.iesdm.proyecto_ecommerce_jpa.domain.Carrito;
import org.iesdm.proyecto_ecommerce_jpa.domain.Producto;
import org.iesdm.proyecto_ecommerce_jpa.domain.Usuario;
import org.iesdm.proyecto_ecommerce_jpa.dto.CarritoDTO;
import org.iesdm.proyecto_ecommerce_jpa.repository.CarritoRepository;
import org.iesdm.proyecto_ecommerce_jpa.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarritoService {

    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;

    public CarritoService(CarritoRepository carritoRepository, ProductoRepository productoRepository) {
        this.carritoRepository = carritoRepository;
        this.productoRepository = productoRepository;
    }

    public List<Carrito> all() {
        return carritoRepository.findAll();
    }

    public Carrito save(Carrito carrito){
        return carritoRepository.save(carrito);
    }

    public void delete(Carrito carrito){
        carritoRepository.delete(carrito);
    }

    public void deleteById(Long id) {
        carritoRepository.deleteById(id);
    }

    //Obtener carrito de un usuario con total
    public CarritoDTO getCarritoConTotal(Long usuarioId) {
        List<Carrito> items = carritoRepository.findByUsuarioId(usuarioId);

        List<CarritoDTO.ProductoCarrito> productos = items.stream()
                .map(item -> {
                    BigDecimal precio = item.getProducto().getPrecio();
                    BigDecimal cantidad = item.getCantidad();
                    BigDecimal subtotal = precio.multiply(cantidad);

                    return CarritoDTO.ProductoCarrito.builder()
                            .productoId(item.getProducto().getId())
                            .nombre(item.getProducto().getNombre())
                            .precio(precio)
                            .cantidad(cantidad)
                            .subtotal(subtotal)
                            .build();
                })
                .collect(Collectors.toList());

        BigDecimal total = productos.stream()
                .map(CarritoDTO.ProductoCarrito::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return CarritoDTO.builder()
                .productos(productos)
                .total(total)
                .build();
    }

    //Añadimos al carrito:
    @Transactional
    public Carrito addToCarrito(Long usuarioId , Long productoId, BigDecimal cantidad){

        //Primero buscamos si ya existe ese producto en el carrito del usuario:
        Carrito existente = carritoRepository.findbyUsuarioAndProducto(usuarioId,productoId);

        //Si no existe crea uno nuevo:

        if(existente == null){
            existente = Carrito.builder()
                    .usuario(Usuario.builder().id(usuarioId).build())
                    .producto(Producto.builder().id(productoId).build())
                    .cantidad(cantidad)
                    .fecha_creacion(LocalDateTime.now())
                    .fecha_modificacion(LocalDateTime.now())
                    .build();
        }
        //Si ya existiera suma la cantidad total del mismo producto en el carrito:

        else{
            existente.setCantidad(existente.getCantidad().add(cantidad));
            existente.setFecha_modificacion(LocalDateTime.now());

        }

        //Guardamos los datos en el carrito:
        return carritoRepository.save(existente);
    }
}
