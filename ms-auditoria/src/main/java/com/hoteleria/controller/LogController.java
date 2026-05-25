package com.hoteleria.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hoteleria.dto.LogRequestDTO;
import com.hoteleria.dto.LogResponseDTO;
import com.hoteleria.service.LogService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/auditoria")
public class LogController {

    @Autowired
    private LogService logService;

    // Endpoint que invoca el WebClient del otro microservicio
    @PostMapping
    public ResponseEntity<Void> crearLog(@Valid @RequestBody LogRequestDTO dto) {
        logService.registrarEvento(dto);
        return ResponseEntity.status(201).build(); // 201 Created sin cuerpo
    }

    // Endpoint para la pantalla de reportes del Administrador
    @GetMapping
    public ResponseEntity<List<LogResponseDTO>> listarLogs() {
        return ResponseEntity.ok(logService.obtenerTodosLosLogs());
    }



}
