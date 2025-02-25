package com.PruebaFacturas.prueba.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClineteDTO {

    private Long id;
    private String nombre;
    private String correo;
    private String telefono;
    private LocalDateTime fechaRegistro;
}
