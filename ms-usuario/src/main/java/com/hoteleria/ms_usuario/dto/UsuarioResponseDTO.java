package com.hoteleria.ms_usuario.dto;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {

    private Long usuarioId;
    private String nombre;
    private String apellido;
    private String rut;
    private String correo;
    private String clave;
    private LocalDate fechaRegistro;
    private LocalDate fechaUltimaClave;

}
