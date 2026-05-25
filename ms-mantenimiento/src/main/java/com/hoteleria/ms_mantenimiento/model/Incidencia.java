package com.hoteleria.ms_mantenimiento.model;

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
@Table(name = "incidencia")
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidencia")
    private Long idIncidencia;

    // Ejemplo: "Aire acondicionado roto", "Fuga de agua"
    @Column(name = "descripcion", length = 500, nullable = false)
    private String descripcion;

    // Ejemplo: "Alta", "Media", "Baja"
    @Column(name = "prioridad", length = 50, nullable = false)
    private String prioridad;

}
