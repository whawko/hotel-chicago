package com.hotel.foto.service;

import com.hotel.foto.dto.FotoRequestDTO;
import com.hotel.foto.exception.ResourceNotFoundException;
import com.hotel.foto.model.FotoHabitacion;
import com.hotel.foto.repository.FotoHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import java.util.List;

@Service
public class FotoHabitacionService {

    @Autowired
    private FotoHabitacionRepository repository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<FotoHabitacion> listarTodas() {
        return repository.findAll();
    }

    public List<FotoHabitacion> listarPorHabitacion(Long habId) {
        return repository.findByHabitacionIdHab(habId);
    }

    public FotoHabitacion guardarFoto(FotoRequestDTO dto) {
        // WebClient apunta al microservicio de Habitaciones (Puerto 8082)
        try {
            webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/api/habitaciones/" + dto.getHabitacionIdHab())
                    .retrieve()
                    .toBodilessEntity()
                    .block();
        } catch (WebClientResponseException.NotFound ex) {
            throw new ResourceNotFoundException("Error Administrativo: No se puede asignar la foto porque la Habitación con ID " + dto.getHabitacionIdHab() + " no existe.");
        } catch (Exception ex) {
            throw new RuntimeException("Incapaz de conectar con el Microservicio de Habitaciones.");
        }

        FotoHabitacion foto = new FotoHabitacion();
        foto.setUrl(dto.getUrl());
        foto.setEsPortada(dto.getEsPortada());
        foto.setHabitacionIdHab(dto.getHabitacionIdHab());

        return repository.save(foto);
    }
}