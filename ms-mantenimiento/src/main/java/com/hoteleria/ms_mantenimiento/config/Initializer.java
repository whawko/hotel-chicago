package com.hoteleria.ms_mantenimiento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Initializer {

    @Bean
    public WebClient webClientIncidencia() {
        return WebClient.builder()
                .baseUrl("http://localhost:8085/api/incidencias") // URL fija de incidencias
                .build();
    }

}
