package com.hoteleria.staff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Initializer {
    @Bean
    public WebClient usuarioWebClient(WebClient.Builder builder) {
        // Configuramos la URL base del microservicio que tiene los usuarios
        return builder.baseUrl("http://localhost:8084/api/usuarios").build();

    }
}