package com.hotel.huesped.repository;

import com.hotel.huesped.model.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, Long> {
    // Buscador clave para la validación
    Optional<Huesped> findByDocumento(String documento);
}