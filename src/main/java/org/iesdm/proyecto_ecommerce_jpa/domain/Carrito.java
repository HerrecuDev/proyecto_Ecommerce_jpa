package org.iesdm.proyecto_ecommerce_jpa.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column
    private BigDecimal cantidad;

    @Column (nullable = false)
    private LocalDateTime fecha_creacion;

    @Column (nullable = false)
    private LocalDateTime fecha_modificacion;

    @ManyToOne
    @JoinColumn(name = "producto_id" , nullable = false)

    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "usuario_id" , nullable = false)

    private Usuario usuario;


}
