package com.hoteleria.staff.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.hoteleria.staff.dto.TurnoLaboralRequestDTO;
import com.hoteleria.staff.dto.TurnoLaboralResponseDTO;
import com.hoteleria.staff.model.TurnoLaboral;
import com.hoteleria.staff.repository.TurnoLaboralRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TurnoLaboralService {

    @Autowired
    private TurnoLaboralRepository turnoLaboralRepository;

    @Autowired
    private WebClient usuarioWebClient; // Conexión al ms-usuarios

    @Autowired
    private WebClient webClientAuditoria; // Conexión al ms-auditoria (de tu Initializer)

    /**
     * CREAR TURNO (Conexión con ms-usuarios y ms-auditoria)
     */
    public TurnoLaboralResponseDTO crearTurno(TurnoLaboralRequestDTO dto) {
        
        // 1. Regla de negocio local: Validar consistencia de horas
        if (dto.getHoraSalida().isBefore(dto.getHoraEntrada())) {
            throw new IllegalArgumentException("La hora de salida no puede ser anterior a la hora de entrada.");
        }

        // 2. CONEXIÓN EXTERNA 1: Validar si el usuario existe en ms-usuarios
        Boolean existeUsuario = usuarioWebClient.get()
                .uri("/existe/{id}", dto.getUsuarioId())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block(); // Bloqueante para asegurar la existencia antes de guardar

        if (existeUsuario == null || !existeUsuario) {
            throw new IllegalArgumentException("Error: El usuario con ID " + dto.getUsuarioId() + " no existe.");
        }

        // 3. Mapear DTO a Entidad y guardar en la BD local de ms-staff
        TurnoLaboral turno = new TurnoLaboral();
        turno.setUsuarioId(dto.getUsuarioId());
        turno.setFecha(dto.getFecha());
        turno.setHoraEntrada(dto.getHoraEntrada());
        turno.setHoraSalida(dto.getHoraSalida());

        TurnoLaboral guardado = turnoLaboralRepository.save(turno);

        // 4. CONEXIÓN EXTERNA 2: Notificar de forma asíncrona al ms-auditoria
        // Usamos .subscribe() para que sea "dispara y olvida" (no frena la respuesta del usuario)
        Map<String, Object> auditoriaData = Map.of(
            "accion", "CREAR_TURNO",
            "detalles", "Se asignó turno al usuario ID: " + dto.getUsuarioId(),
            "entidadId", guardado.getIdTurno()
        );

        webClientAuditoria.post()
                .bodyValue(auditoriaData)
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe(
                    success -> System.out.println("Auditoría enviada con éxito"),
                    error -> System.err.println("No se pudo enviar la auditoría: " + error.getMessage())
                );

        // 5. Retornar el DTO de respuesta
        return convertirADTO(guardado);
    }

    /**
     * LISTAR TODOS LOS TURNOS
     */
    public List<TurnoLaboralResponseDTO> obtenerTodosLosTurnos() {
        List<TurnoLaboral> turnos = turnoLaboralRepository.findAll();
        return turnos.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    /**
     * MÉTODO AUXILIAR DE CONVERSIÓN
     */
    private TurnoLaboralResponseDTO convertirADTO(TurnoLaboral entidad) {
        TurnoLaboralResponseDTO dto = new TurnoLaboralResponseDTO();
        dto.setIdTurno(entidad.getIdTurno());
        dto.setUsuarioId(entidad.getUsuarioId());
        dto.setFecha(entidad.getFecha());
        dto.setHoraEntrada(entidad.getHoraEntrada());
        dto.setHoraSalida(entidad.getHoraSalida());
        return dto;
    }

}
