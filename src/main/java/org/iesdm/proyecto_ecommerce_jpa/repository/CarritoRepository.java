package org.iesdm.proyecto_ecommerce_jpa.repository;

import org.iesdm.proyecto_ecommerce_jpa.domain.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {

    //Buscamos si ya existe una fila con ese usuario y ese producto.
    @Query("SELECT c FROM Carrito c WHERE c.usuario.id = :usuarioId AND c.producto.id = :productoId")
    Carrito findbyUsuarioAndProducto(Long usuarioId, Long productoId);

    //Buscar todos los items del carrito de un usuario
    List<Carrito> findByUsuarioId(Long usuarioId);

}
