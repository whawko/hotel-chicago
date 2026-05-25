package com.hoteleria.ms_usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(max = 120, message = "El nombre no puede superar los 120 caracteres")
    private String nombre;
    @NotBlank(message = "El apellido no puede estar vacio")
    @Size(max = 120, message = "El apellido no puede superar los 120 caracteres")
    private String apellido;
    @NotBlank(message = "El rut no puede estar vacio")
    @Size(max = 12, message = "El rut no puede superar los 12 caracteres")
    private String rut;
    @NotBlank(message = "El correo no puede estar vacio")
    @Size(max = 120, message = "El correo no puede superar los 120 caracteres")
    private String correo;
    @NotBlank(message = "La clave no puede estar vacio")
    @Size(max = 120, message = "El clave no puede superar los 120 caracteres")
    private String clave;
    
}
