package com.hoteleria.ms_mantenimiento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncidenciaResponseDTO {

    private Long idIncidencia;
    private String descripcion;
    private String prioridad;
}
