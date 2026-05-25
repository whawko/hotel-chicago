package com.hoteleria.ms_usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hoteleria.ms_usuario.model.ConfigPassword;

@Repository
public interface ConfigPasswordRepository extends JpaRepository<ConfigPassword, Long> {

}
