package com.hoteleria.ms_mantenimiento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncidenciaRequestDTO {

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    private String descripcion;
    
    @NotBlank(message = "Debes asignar una prioridad (Ej: Alta, Media, Baja)")
    @Size(max = 50, message = "La prioridad no puede superar los 50 caracteres")
    private String prioridad;

}
