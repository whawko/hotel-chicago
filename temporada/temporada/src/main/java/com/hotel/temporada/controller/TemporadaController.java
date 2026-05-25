package com.hotel.temporada.controller;

import com.hotel.temporada.model.Temporada;
import com.hotel.temporada.service.TemporadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temporadas")
public class TemporadaController {

    @Autowired
    private TemporadaService service;

    @GetMapping
    public List<Temporada> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Temporada> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Temporada temporada) {
        try {
            service.guardarTemporada(temporada);
            return new ResponseEntity<>("Temporada creada con éxito", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}