package com.hoteleria.ms_usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteleria.ms_usuario.model.Rol;
import com.hoteleria.ms_usuario.repository.RolRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolService {
    
    @Autowired
    private RolRepository rolRepository;

    //Guarda un nuevo rol en el sistema (ej: "RECEPCIONISTA").
    public Rol guardarRol(Rol rol) {
        // Podrías pasar el nombre a mayúsculas para mantener consistencia en la BD
        if (rol.getNombre() != null) {
            rol.setNombre(rol.getNombre().toUpperCase());
        }
        return rolRepository.save(rol);
    }

    //Lista todos los roles disponibles para asignar a los usuarios.
    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }

    //Busca un rol específico. Si no existe, lanza un error controlado.
    public Rol obtenerPorId(Long id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con el ID: " + id));
    }

    //Borra un rol por su ID si este existe.
    public void eliminarRol(Long id) {
        if (!rolRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar. Rol no encontrado con el ID: " + id);
        }
        rolRepository.deleteById(id);
    }

}
