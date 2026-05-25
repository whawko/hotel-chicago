package com.hotel.huesped.service;

import com.hotel.huesped.model.Huesped;
import com.hotel.huesped.repository.HuespedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import java.util.List;

@Service
public class HuespedService {

    @Autowired
    private HuespedRepository repository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Huesped> listarTodos() {
        return repository.findAll();
    }

    public Huesped buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el huésped con ID: " + id));
    }

    public Huesped guardarHuesped(Huesped huesped) {

        if (repository.findByDocumento(huesped.getDocumento()).isPresent()) {
            throw new IllegalArgumentException("Error: Ya existe un huésped registrado con el documento: " + huesped.getDocumento());
        }

        try {
            webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8083/api/estados/" + huesped.getEstadoIdEstado())
                    .retrieve()
                    .toBodilessEntity()
                    .block();
        } catch (WebClientResponseException.NotFound ex) {
            throw new RuntimeException("Error: El Estado con ID " + huesped.getEstadoIdEstado() + " no existe.");
        } catch (Exception ex) {
            throw new RuntimeException("Error de comunicación: El Microservicio de Estados (8083) está caído.");
        }

        return repository.save(huesped);
    }
}