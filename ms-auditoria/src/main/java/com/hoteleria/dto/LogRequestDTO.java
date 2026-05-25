package com.hoteleria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LogRequestDTO {
    @NotNull
    private Long usuarioId;
    @NotBlank
    private String accion;
    @NotBlank
    private String ipOrigen;
}
