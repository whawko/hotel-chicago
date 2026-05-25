package com.hoteleria.ms_mantenimiento.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteleria.ms_mantenimiento.dto.IncidenciaRequestDTO;
import com.hoteleria.ms_mantenimiento.dto.IncidenciaResponseDTO;
import com.hoteleria.ms_mantenimiento.model.Incidencia;
import com.hoteleria.ms_mantenimiento.repository.IncidenciaRepository;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    /**
     * CREAR INCIDENCIA
     * Ahora retorna IncidenciaResponseDTO para que coincida con tu Controller
     */
    public IncidenciaResponseDTO crearIncidencia(IncidenciaRequestDTO dto) {
        
        Incidencia incidencia = new Incidencia();
        incidencia.setDescripcion(dto.getDescripcion());
        incidencia.setPrioridad(dto.getPrioridad());

        Incidencia guardada = incidenciaRepository.save(incidencia);

        return convertirADTO(guardada);
    }

    /**
     * LISTAR TODAS LAS INCIDENCIAS
     */
    public List<IncidenciaResponseDTO> obtenerTodasLasIncidencias() {
        List<Incidencia> incidencias = incidenciaRepository.findAll();
        
        return incidencias.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    /**
     * MÉTODO AUXILIAR DE CONVERSIÓN
     */
    private IncidenciaResponseDTO convertirADTO(Incidencia entidad) {
        IncidenciaResponseDTO dto = new IncidenciaResponseDTO();
        dto.setIdIncidencia(entidad.getIdIncidencia());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setPrioridad(entidad.getPrioridad());
        return dto;
    }

}
