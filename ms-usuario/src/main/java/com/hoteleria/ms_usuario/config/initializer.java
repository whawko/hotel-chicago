package com.hoteleria.ms_usuario.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class initializer {
    @Bean
    public WebClient webClientAuditoria() {
        return WebClient.builder()
                .baseUrl("http://localhost:8082/api/auditoria") // URL fija de auditoría
                .build();
    }
}
