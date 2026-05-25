package com.hoteleria.ms_mantenimiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoteleria.ms_mantenimiento.model.Incidencia;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Long>{

}
