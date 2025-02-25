package com.PruebaFacturas.prueba.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {
    private Long id;
    private Long idCliente;
    private LocalDateTime fechaEmision;
    private Double total;
    private String estado;
}
