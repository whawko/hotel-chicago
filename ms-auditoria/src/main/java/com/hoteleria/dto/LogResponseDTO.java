package com.hoteleria.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class LogResponseDTO {
    private Long idLog;
    private Long usuarioId;
    private String accion;
    private LocalDateTime fechaHora;
    private String ipOrigen;
}
