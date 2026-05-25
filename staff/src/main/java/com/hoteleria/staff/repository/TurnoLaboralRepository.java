package com.hoteleria.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoteleria.staff.model.TurnoLaboral;

@Repository
public interface TurnoLaboralRepository extends JpaRepository<TurnoLaboral,Long>{

}
