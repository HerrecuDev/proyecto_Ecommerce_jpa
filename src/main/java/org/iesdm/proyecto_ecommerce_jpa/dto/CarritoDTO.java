package org.iesdm.proyecto_ecommerce_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarritoDTO {

    private List<ProductoCarrito> productos;
    private BigDecimal total;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ProductoCarrito {
        private Long productoId;
        private String nombre;
        private BigDecimal precio;
        private BigDecimal cantidad;
        private BigDecimal subtotal;
    }
}
