package com.hoteleria.staff.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnoLaboralResponseDTO {
    private Long idTurno;
    private Long usuarioId; // Se devuelve el ID del empleado asignado
    private LocalDate fecha;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;

}
