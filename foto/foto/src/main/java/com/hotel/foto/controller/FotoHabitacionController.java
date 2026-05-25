package com.hotel.foto.controller;

import com.hotel.foto.dto.FotoRequestDTO;
import com.hotel.foto.model.FotoHabitacion;
import com.hotel.foto.service.FotoHabitacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fotos")
public class FotoHabitacionController {

    @Autowired
    private FotoHabitacionService service;

    @GetMapping
    public List<FotoHabitacion> listar() {
        return service.listarTodas();
    }

    @GetMapping("/habitacion/{habId}")
    public List<FotoHabitacion> listarPorHabitacion(@PathVariable Long habId) {
        return service.listarPorHabitacion(habId);
    }

    @PostMapping
    public ResponseEntity<FotoHabitacion> crear(@Valid @RequestBody FotoRequestDTO dto) {
        return new ResponseEntity<>(service.guardarFoto(dto), HttpStatus.CREATED);
    }
}