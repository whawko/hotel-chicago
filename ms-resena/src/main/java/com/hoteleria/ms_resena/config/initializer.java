package com.hoteleria.ms_resena.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class initializer {
    
    @Bean
    public WebClient webClientResena() {
        return WebClient.builder()
                .baseUrl("http://localhost:8085/api/resenas") // URL fija de incidencias
                .build();
    }

}
