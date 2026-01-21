package org.iesdm.proyecto_ecommerce_jpa.repository;

import org.iesdm.proyecto_ecommerce_jpa.domain.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {

    //Buscamos si ya existe una fila con ese usuario y ese producto.
    @Query("SELECT c FROM Carrito c WHERE c.usuario.id = :usuarioID AND c.producto.id = :productoID")
    Carrito findbyUsuarioAndProducto(Long usuarioId, Long productoId);



}
