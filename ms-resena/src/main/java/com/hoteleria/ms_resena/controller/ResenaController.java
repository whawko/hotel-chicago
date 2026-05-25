package com.hoteleria.ms_resena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoteleria.ms_resena.dto.ResenaRequestDTO;
import com.hoteleria.ms_resena.dto.ResenaResponseDTO;
import com.hoteleria.ms_resena.service.ResenaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    // 1. POST: Para crear y guardar una nueva reseña
    // El @Valid activa las anotaciones (@Min, @Max, @NotBlank) del ResenaRequestDTO
    @PostMapping
    public ResponseEntity<ResenaResponseDTO> crearResena(@Valid @RequestBody ResenaRequestDTO dto) {
        ResenaResponseDTO nuevaResena = resenaService.crearResena(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaResena); // Devuelve HTTP 201
    }

    // 2. GET: Para obtener el listado de todas las reseñas del sistema
    @GetMapping
    public ResponseEntity<List<ResenaResponseDTO>> listarResenas() {
        List<ResenaResponseDTO> lista = resenaService.obtenerTodas();
        return ResponseEntity.ok(lista); // Devuelve HTTP 200 OK con la lista JSON
    }

}
