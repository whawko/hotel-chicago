package com.hoteleria.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteleria.dto.LogRequestDTO;
import com.hoteleria.dto.LogResponseDTO;
import com.hoteleria.model.Log;
import com.hoteleria.repository.LogRepository;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

   // Guarda el log recibido por HTTP
    public void registrarEvento(LogRequestDTO dto) {
        Log log = new Log();
        log.setUsuarioId(dto.getUsuarioId());
        log.setAccion(dto.getAccion());
        log.setIpOrigen(dto.getIpOrigen());
        log.setFechaHora(LocalDateTime.now()); // El sistema le pone la hora exacta del servidor

        logRepository.save(log);
    }

    // Devuelve todos los registros transformados a DTO
    public List<LogResponseDTO> obtenerTodosLosLogs() {
        return logRepository.findAll().stream().map(log -> {
            LogResponseDTO dto = new LogResponseDTO();
            dto.setIdLog(log.getIdLog());
            dto.setUsuarioId(log.getUsuarioId());
            dto.setAccion(log.getAccion());
            dto.setFechaHora(log.getFechaHora());
            dto.setIpOrigen(log.getIpOrigen());
            return dto;
        }).collect(Collectors.toList());
    }
    
}