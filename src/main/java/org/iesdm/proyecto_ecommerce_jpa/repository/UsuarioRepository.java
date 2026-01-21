package org.iesdm.proyecto_ecommerce_jpa.repository;

import org.iesdm.proyecto_ecommerce_jpa.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
