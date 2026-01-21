package org.iesdm.proyecto_ecommerce_jpa.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 120)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 120)
    private String imagen;

    @Column(length = 120)
    private String sku;

    @Column(nullable = false , precision = 10, scale = 3)
    private BigDecimal precio;

    @Column
    private BigDecimal cantidad;

    @OneToMany(mappedBy = "producto")
    @Builder.Default
    @ToString.Exclude

    //AL ser relacion 1 @ * con carrito:
    private Set<Carrito> carrito = new HashSet<>();

    //AL ser relacion * @ 1 con categoria
    @ManyToOne
    private Categoria categoria;
}
