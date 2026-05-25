package com.hoteleria.ms_mantenimiento.controller;

import java.util.List;
import jakarta.validation.Valid;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoteleria.ms_mantenimiento.dto.IncidenciaRequestDTO;
import com.hoteleria.ms_mantenimiento.dto.IncidenciaResponseDTO;
import com.hoteleria.ms_mantenimiento.service.IncidenciaService;



@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    @PostMapping
    public ResponseEntity<IncidenciaResponseDTO> registrarIncidencia(@Valid @RequestBody IncidenciaRequestDTO dto) {
        IncidenciaResponseDTO nuevaIncidencia = incidenciaService.crearIncidencia(dto);
        return new ResponseEntity<>(nuevaIncidencia, HttpStatus.CREATED); // Retorna HTTP 201 Created
    }

    /**
     * 2. GET: Listar todas las incidencias registradas
     */
    @GetMapping
    public ResponseEntity<List<IncidenciaResponseDTO>> listarIncidencias() {
        List<IncidenciaResponseDTO> lista = incidenciaService.obtenerTodasLasIncidencias();
        return ResponseEntity.ok(lista); // Retorna HTTP 200 OK
    }

}
