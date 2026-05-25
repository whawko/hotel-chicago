package com.hotel.huesped.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "huesped")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Huesped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_huesped")
    private Long idHuesped;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "documento", length = 20, unique = true)
    private String documento;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "telefono", length = 20)
    private String telefono;

    // Conexión lógica con el ID de Estado (puerto 8083)
    @Column(name = "estado_id_estado")
    private Long estadoIdEstado;
}