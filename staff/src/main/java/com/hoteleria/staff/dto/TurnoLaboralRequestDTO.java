package com.hoteleria.staff.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnoLaboralRequestDTO {
    @NotNull(message = "El ID del usuario/empleado es obligatorio.")
    private Long usuarioId; // El ID que envías al WebClient para verificar

    @NotNull(message = "La fecha del turno es obligatoria.")
    private LocalDate fecha; // Formato esperado en JSON: "YYYY-MM-DD"

    @NotNull(message = "La hora de entrada es obligatoria.")
    private LocalTime horaEntrada; // Formato esperado en JSON: "HH:mm:ss" o "HH:mm"

    @NotNull(message = "La hora de salida es obligatoria.")
    private LocalTime horaSalida;
}
