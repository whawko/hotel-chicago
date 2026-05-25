package com.hoteleria.ms_usuario.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(nullable = false, length = 70)
    private String nombre;
    @Column(nullable = false, length = 70)
    private String apellido;
    @Column(nullable = false, length = 12)
    private String rut;
    @Column(nullable = false, length = 70)
    private String correo;
    @Column(nullable = false, length = 100)
    private String clave;
    @Column(name = "fecha_registro", updatable = false)
    private LocalDate fechaRegistro;
    @Column(name = "fecha_ultima_clave")
    private LocalDate fechaUltimaClave;


    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rolId;

}
