package com.hoteleria.model;

import java.time.LocalDateTime;

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
@Table(name = "log_sistema")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log", nullable = false)
    private Long idLog;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;
    @Column(name = "accion", nullable = false)
    private String accion;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;
    @Column(name = "ip_origen", nullable = false)
    private String ipOrigen;


}
