package org.iesdm.proyecto_ecommerce_jpa.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.web.JsonPath;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 120)
    private String email;

    @Column(length = 120)
    private String username;

    @Column(length = 120)
    private String password;

    @Column
    private LocalDateTime fecha_Nacimiento;

    @OneToMany(mappedBy = "usuario")
    @Builder.Default
    @ToString.Exclude


    private Set<Carrito> carrito = new HashSet<>();

}
