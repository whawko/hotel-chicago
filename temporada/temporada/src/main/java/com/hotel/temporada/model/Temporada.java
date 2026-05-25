package com.hotel.temporada.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "temporada")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_temporada")
    private Long idTemporada;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "multip_precio")
    private Double multipPrecio;

    @Column(name = "estado_id_estado")
    private Long estadoIdEstado;
}