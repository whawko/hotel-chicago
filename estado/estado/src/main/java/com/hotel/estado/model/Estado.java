package com.hotel.estado.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estado")
@Data
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Long idEstado;

    @Column(name = "nombre", length = 50, unique = true)
    private String nombre;

    @Column(name = "descripcion", length = 250)
    private String descripcion;
}