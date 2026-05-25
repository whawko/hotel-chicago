package com.hotel.habitacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_hab")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hab")
    private Long idHab;

    private Integer numero;
    private Integer piso;

    @Column(length = 100)
    private String observacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_hab_id_tipo", nullable = false)
    private TipoHabitacion tipoHabitacion;

    @Column(name = "estado_id_estado")
    private Long estadoIdEstado;
}
