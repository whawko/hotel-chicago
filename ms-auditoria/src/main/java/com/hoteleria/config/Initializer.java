package com.hoteleria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;



@Configuration
public class Initializer {
    ///codigo que construye automaticamente el 
    // cliente sin necesidad de hacer codigo en el service
    @Bean
    public WebClient webClientAuditoria() {
        return WebClient.builder()
                .baseUrl("http://localhost:8082/api/auditoria") // URL fija de auditoría
                .build();
    }
    
}
