package com.hotel.foto.repository;

import com.hotel.foto.model.FotoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FotoHabitacionRepository extends JpaRepository<FotoHabitacion, Long> {
    List<FotoHabitacion> findByHabitacionIdHab(Long habitacionIdHab);
}