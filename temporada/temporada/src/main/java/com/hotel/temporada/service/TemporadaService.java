package com.hotel.temporada.service;

import com.hotel.temporada.model.Temporada;
import com.hotel.temporada.repository.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import java.util.List;

@Service
public class TemporadaService {

    @Autowired
    private TemporadaRepository repository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Temporada> listarTodas() {
        return repository.findAll();
    }

    public Temporada buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la temporada con ID: " + id));
    }

    public Temporada guardarTemporada(Temporada temporada) {

        if (temporada.getFechaFin().isBefore(temporada.getFechaInicio())) {
            throw new IllegalArgumentException("Error: La fecha de fin no puede ser anterior a la fecha de inicio.");
        }

        try {
            webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8083/api/estados/" + temporada.getEstadoIdEstado())
                    .retrieve()
                    .toBodilessEntity()
                    .block(); 
        } catch (WebClientResponseException.NotFound ex) {
            throw new RuntimeException("Error: El Estado con ID " + temporada.getEstadoIdEstado() + " no existe en el sistema.");
        } catch (Exception ex) {
            throw new RuntimeException("Error de comunicación: El Microservicio de Estados (8083) está caído.");
        }

        return repository.save(temporada);
    }
}