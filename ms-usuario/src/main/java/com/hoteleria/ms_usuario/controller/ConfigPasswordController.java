package com.hoteleria.ms_usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoteleria.ms_usuario.dto.ConfigPasswordRequestDTO;
import com.hoteleria.ms_usuario.dto.ConfigPasswordResponseDTO;
import com.hoteleria.ms_usuario.service.ConfigPasswordService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/password")
public class ConfigPasswordController {

    @Autowired
    private ConfigPasswordService configService;

    // 1. OBTENER la configuración actual (Para cargar el formulario del Admin)
    @GetMapping
    public ResponseEntity<ConfigPasswordResponseDTO> obtenerConfiguracion() {
        // Llamamos al service que busca el ID 1
        return ResponseEntity.ok(configService.obtenerConfiguracion());
    }

    // 2. GUARDAR o ACTUALIZAR la configuración
    @PostMapping
    public ResponseEntity<ConfigPasswordResponseDTO> guardarConfiguracion(
            @Valid @RequestBody ConfigPasswordRequestDTO dto) {
        
        // El @Valid activa todas las reglas que pusimos (@Min, @Max, @Pattern)
        ConfigPasswordResponseDTO respuesta = configService.guardarConfiguracion(dto);
        
        // Retornamos 201 Created o 200 OK
        return ResponseEntity.status(201).body(respuesta);

}

}