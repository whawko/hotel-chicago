package com.hoteleria.ms_usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoteleria.ms_usuario.model.Rol;
import com.hoteleria.ms_usuario.service.RolService;

@RestController
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    // 1. POST: Crear un nuevo Rol (ej: Administrador, Recepcionista)
    @PostMapping
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol) {
        Rol nuevoRol = rolService.guardarRol(rol);
        return new ResponseEntity<>(nuevoRol, HttpStatus.CREATED);
    }

    // 2. GET: Listar todos los roles
    @GetMapping
    public ResponseEntity<List<Rol>> listarTodos() {
        List<Rol> roles = rolService.obtenerTodos();
        return ResponseEntity.ok(roles);
    }

    // 3. GET por ID: Obtener un rol específico
    @GetMapping("/{id}")
    public ResponseEntity<Rol> buscarPorId(@PathVariable("id") Long id) {
        Rol rol = rolService.obtenerPorId(id);
        return ResponseEntity.ok(rol);
    }

    // 4. DELETE: Eliminar un rol por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable("id") Long id) {
        rolService.eliminarRol(id);
        return ResponseEntity.noContent().build(); // Devuelve HTTP 204 No Content
    }
}