package com.hoteleria.ms_resena.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteleria.ms_resena.dto.ResenaRequestDTO;
import com.hoteleria.ms_resena.dto.ResenaResponseDTO;
import com.hoteleria.ms_resena.model.Resena;
import com.hoteleria.ms_resena.repository.ResenaRepository;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    // 1. MÉTODO: Crear y guardar la reseña
    public ResenaResponseDTO crearResena(ResenaRequestDTO dto) {
        Resena resena = new Resena();
        
        // Pasamos los datos del Request DTO a la Entidad
        resena.setPuntuacionHab(dto.getPuntuacionHab());
        resena.setPuntuacionServicio(dto.getPuntuacionServicio());
        resena.setComentario(dto.getComentario());
        
        // NOTA: No seteamos la fecha aquí. Al guardar, Hibernate respetará 
        // el 'insertable = false' y la base de datos le asignará el SYSDATE.

        // Guardamos en la base de datos
        Resena guardada = resenaRepository.save(resena);

        // Convertimos la entidad guardada (que ya trae su ID) a Response DTO
        return convertirADTO(guardada);
    }

    // 2. MÉTODO: Obtener todas las reseñas
    public List<ResenaResponseDTO> obtenerTodas() {
        List<Resena> listaEntidades = resenaRepository.findAll();
        
        // Transformamos la lista de entidades a una lista de DTOs para el controlador
        return listaEntidades.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // MÉTODO AUXILIAR: Transforma una Entidad a un Response DTO limpio
    private ResenaResponseDTO convertirADTO(Resena entidad) {
        ResenaResponseDTO dto = new ResenaResponseDTO();
        dto.setIdResena(entidad.getIdResena());
        dto.setPuntuacionHab(entidad.getPuntuacionHab());
        dto.setPuntuacionServicio(entidad.getPuntuacionServicio());
        dto.setComentario(entidad.getComentario());
        dto.setFechaPublicacion(entidad.getFechaPublicacion());
        return dto;
    }

}
