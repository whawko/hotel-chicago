package com.hotel.habitacion.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class HabitacionRequestDTO {

    @NotNull(message = "El número de habitación es obligatorio")
    @Positive(message = "El número debe ser un dígito positivo")
    private Integer numero;

    @NotNull(message = "El piso es obligatorio")
    private Integer piso;

    @Size(max = 100, message = "La observación no debe superar los 100 caracteres")
    private String observacion;

    @NotNull(message = "El ID del Tipo de Habitación es requerido")
    private Long tipoHabitacionId;

    @NotNull(message = "El ID del Estado es requerido")
    private Long estadoIdEstado;
}
