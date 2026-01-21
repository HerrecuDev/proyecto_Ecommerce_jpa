package org.iesdm.proyecto_ecommerce_jpa.repository;

import org.iesdm.proyecto_ecommerce_jpa.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {


}
