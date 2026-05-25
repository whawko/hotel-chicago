package com.hoteleria.ms_usuario.model;

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
@Table(name = "config_clave")
public class ConfigPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "longitud_min")
    private int longitudMin;

    @Column(name = "requiere_mayuscula")
    private String requiereMayuscula;

    @Column(name = "requiere_numero")
    private String requiereNumero;

    @Column(name = "requiere_especial")
    private String requiereEspecial;

    @Column(name = "dias_expiracion")
    private int diasExpiracion;

    @Column(name = "intentos_maximos")
    private int intentosMaximos;

    @Column(name = "historial_clave")
    private int historialClaves;
}
