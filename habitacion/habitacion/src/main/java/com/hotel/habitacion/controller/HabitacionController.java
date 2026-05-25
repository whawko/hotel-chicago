package com.hotel.habitacion.controller;

import com.hotel.habitacion.dto.HabitacionRequestDTO;
import com.hotel.habitacion.model.Habitacion;
import com.hotel.habitacion.service.HabitacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionService service;

    @GetMapping
    public List<Habitacion> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Habitacion> crear(@Valid @RequestBody HabitacionRequestDTO dto) {
        Habitacion nuevaHabitacion = service.crearHabitacion(dto);
        return new ResponseEntity<>(nuevaHabitacion, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}