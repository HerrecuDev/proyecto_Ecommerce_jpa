package org.iesdm.proyecto_ecommerce_jpa.repository;

import org.iesdm.proyecto_ecommerce_jpa.domain.Categoria;
import org.iesdm.proyecto_ecommerce_jpa.domain.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    public List<Producto> findByCategoria(Categoria categoria);

    public Page<Producto> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);

}
