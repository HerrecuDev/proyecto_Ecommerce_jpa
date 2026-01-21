package org.iesdm.proyecto_ecommerce_jpa.repository;

import org.iesdm.proyecto_ecommerce_jpa.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
