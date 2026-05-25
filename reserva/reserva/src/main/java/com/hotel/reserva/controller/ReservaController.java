package com.hotel.reserva.controller;

import com.hotel.reserva.model.Reserva;
import com.hotel.reserva.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public List<Reserva> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Reserva reserva) {
        try {
            service.guardarReserva(reserva);
            return new ResponseEntity<>("Reserva registrada con éxito", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}