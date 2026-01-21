package org.iesdm.proyecto_ecommerce_jpa.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 120)
    private String nombre;
    private String descripcion;


    //Al tener una relacion de 1 @ * con producto
    @OneToMany( mappedBy = "categoria")
    @Builder.Default
    @ToString.Exclude

    private Set<Producto> productos = new HashSet<>();
}
