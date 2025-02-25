package com.PruebaFacturas.prueba.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFacturaDTO {

    private Long id;
    private Long idFactura;
    private String descripcion;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;

}
