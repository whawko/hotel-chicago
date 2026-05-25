package com.hoteleria.ms_resena.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ResenaRequestDTO {

    @NotNull(message = "La puntuación de la habitación es obligatoria.")
    @Min(value = 1, message = "La puntuación mínima es 1.")
    @Max(value = 5, message = "La puntuación máxima es 5.")
    private Integer puntuacionHab;

    @NotNull(message = "La puntuación del servicio es obligatoria.")
    @Min(value = 1, message = "La puntuación mínima es 1.")
    @Max(value = 5, message = "La puntuación máxima es 5.")
    private Integer puntuacionServicio; // <-- Igual al nombre del modelo

    @NotBlank(message = "El comentario no puede estar vacío.")
    @Size(max = 500, message = "El comentario no puede superar los 500 caracteres.")
    private String comentario;

}
