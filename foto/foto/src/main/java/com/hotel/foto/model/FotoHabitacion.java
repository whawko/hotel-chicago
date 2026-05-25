package com.hotel.foto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "foto_hab")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FotoHabitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    private Long idFoto;

    @Column(name = "url", length = 250)
    private String url;

    @Column(name = "es_portada", length = 90)
    private String esPortada;

    // Guardamos solo el ID de forma desacoplada
    @Column(name = "habitacion_id_hab")
    private Long habitacionIdHab;
}