package com.hotel.habitacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_hab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nombre", length = 90)
    private String nombre;

    @Column(name = "descripcion", length = 450)
    private String descripcion;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "capaci_max")
    private Integer capaciMax;

    @Column(name = "vista", length = 60)
    private String vista;
    
    @Column(name = "estado_id_estado")
    private Long estadoIdEstado;

}
