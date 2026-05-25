package com.hoteleria.ms_usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 4, max = 50, message ="El nombre debe ser entre 4 a 50 caracteres" )
    private String nombre;
    
}
