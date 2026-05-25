package com.hoteleria.ms_resena.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ResenaResponseDTO {
    private Long idResena;
    private Integer puntuacionHab;
    private Integer puntuacionServicio;
    private String comentario;
    private LocalDate fechaPublicacion;

}
