package com.PruebaFacturas.prueba.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagosDTO {

    private Long idPago;
    private Long idFactura;
    private Double montoPagado;
    private String metodoPago;
    private LocalDateTime fechaPago;

}
