package com.hotel.reserva.service;

import com.hotel.reserva.model.Reserva;
import com.hotel.reserva.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Reserva> listarTodas() {
        return repository.findAll();
    }

    public Reserva guardarReserva(Reserva reserva) {
        if (!reserva.getFechaSalida().isAfter(reserva.getFechaEntrada())) {
            throw new IllegalArgumentException("Error: La fecha de salida debe ser posterior a la fecha de entrada.");
        }

        try {
            webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/api/habitaciones/" + reserva.getHabitacionIdHab())
                    .retrieve()
                    .toBodilessEntity()
                    .block();
        } catch (WebClientResponseException.NotFound ex) {
            throw new RuntimeException("Error Comercial: La Habitación con ID " + reserva.getHabitacionIdHab() + " no existe.");
        } catch (Exception ex) {
            throw new RuntimeException("Error: El Microservicio de Habitaciones (8082) no responde.");
        }

        try {
            webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8083/api/estados/" + reserva.getEstadoIdEstado())
                    .retrieve()
                    .toBodilessEntity()
                    .block();
        } catch (WebClientResponseException.NotFound ex) {
            throw new RuntimeException("Error Comercial: El Estado de Reserva con ID " + reserva.getEstadoIdEstado() + " no existe.");
        } catch (Exception ex) {
            throw new RuntimeException("Error: El Microservicio de Estados (8083) no responde.");
        }

        return repository.save(reserva);
    }
}