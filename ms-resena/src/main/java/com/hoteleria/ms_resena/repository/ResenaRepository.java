package com.hoteleria.ms_resena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoteleria.ms_resena.model.Resena;


@Repository
public interface ResenaRepository extends JpaRepository<Resena,Long> {

}
