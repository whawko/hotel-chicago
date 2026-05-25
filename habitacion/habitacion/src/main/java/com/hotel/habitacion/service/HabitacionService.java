package com.hotel.habitacion.service;

import com.hotel.habitacion.dto.HabitacionRequestDTO;
import com.hotel.habitacion.exception.ResourceNotFoundException;
import com.hotel.habitacion.model.Habitacion;
import com.hotel.habitacion.model.TipoHabitacion;
import com.hotel.habitacion.repository.HabitacionRepository;
import com.hotel.habitacion.repository.TipoHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import java.util.List;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Habitacion> listarTodas() {
        return habitacionRepository.findAll();
    }

    public Habitacion buscarPorId(Long id) {
        return habitacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habitación no encontrada con el ID: " + id));
    }

    public Habitacion crearHabitacion(HabitacionRequestDTO dto) {
        try {
            webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8083/api/estados/" + dto.getEstadoIdEstado())
                    .retrieve()
                    .toBodilessEntity()
                    .block(); 
        } catch (WebClientResponseException.NotFound ex) {
            throw new ResourceNotFoundException("Validación Administrativa Fallida: El Estado con ID " + dto.getEstadoIdEstado() + " no está registrado en el sistema.");
        } catch (Exception ex) {
            throw new RuntimeException("Incapaz de conectar con el Microservicio de Estados para validación.");
        }

        TipoHabitacion tipoHab = tipoHabitacionRepository.findById(dto.getTipoHabitacionId())
                .orElseThrow(() -> new ResourceNotFoundException("El Tipo de Habitación con ID " + dto.getTipoHabitacionId() + " no existe."));

        Habitacion habitacion = new Habitacion();
        habitacion.setNumero(dto.getNumero());
        habitacion.setPiso(dto.getPiso());
        habitacion.setObservacion(dto.getObservacion());
        habitacion.setTipoHabitacion(tipoHab);
        habitacion.setEstadoIdEstado(dto.getEstadoIdEstado());

        return habitacionRepository.save(habitacion);
    }

    public void eliminar(Long id) {
        if (!habitacionRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar. Habitación no encontrada con ID: " + id);
        }
        habitacionRepository.deleteById(id);
    }
}