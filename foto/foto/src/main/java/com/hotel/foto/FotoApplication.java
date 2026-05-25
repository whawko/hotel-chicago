package com.hotel.foto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "com.hotel.foto") 
@EnableJpaRepositories(basePackages = "com.hotel.foto.repository") 
@EntityScan(basePackages = "com.hotel.foto.model") 
public class FotoApplication {
    public static void main(String[] args) {
        SpringApplication.run(FotoApplication.class, args);
    }
}