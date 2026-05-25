package com.hoteleria.staff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoteleria.staff.dto.TurnoLaboralRequestDTO;
import com.hoteleria.staff.dto.TurnoLaboralResponseDTO;
import com.hoteleria.staff.service.TurnoLaboralService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/turnos")
public class TurnoLaboralController {

    @Autowired
    private TurnoLaboralService turnoLaboralService;

    @PostMapping
    public ResponseEntity<TurnoLaboralResponseDTO> crearTurno(@Valid @RequestBody TurnoLaboralRequestDTO dto) {
        TurnoLaboralResponseDTO nuevoTurno = turnoLaboralService.crearTurno(dto);
        return new ResponseEntity<>(nuevoTurno, HttpStatus.CREATED); // Devuelve HTTP 201
    }

    // 2. GET: Listar todos los turnos registrados
    @GetMapping
    public ResponseEntity<List<TurnoLaboralResponseDTO>> obtenerTodosLosTurnos() {
        List<TurnoLaboralResponseDTO> turnos = turnoLaboralService.obtenerTodosLosTurnos();
        return ResponseEntity.ok(turnos); // Devuelve HTTP 200 OK
    }

}
