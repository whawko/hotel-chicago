package com.hoteleria.ms_resena.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resenas")
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resena") // Mapea exactamente el nombre snake_case de la BD
    private Long idResena;

    
    @Column(name = "puntuacion_hab", nullable = false)
    private int puntuacionHab;

    @Column(name = "puntuacion_servicio", nullable = false) // Corregido para que coincida con tu DTO y evites errores
    private int puntuacionServicio;

    
    @Column(name = "comentario", nullable = false, length = 500)
    private String comentario;

    
    @Column(name = "fecha_publicacion", insertable = false, updatable = false)
    private LocalDate fechaPublicacion;


}
