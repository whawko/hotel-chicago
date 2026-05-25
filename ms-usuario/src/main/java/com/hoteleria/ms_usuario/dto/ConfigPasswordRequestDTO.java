package com.hoteleria.ms_usuario.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigPasswordRequestDTO {
    @NotNull(message = "La longitud mínima es obligatoria")
    @Min(value = 6, message = "La longitud mínima no puede ser menor a 6 caracteres")
    @Max(value = 20, message = "La longitud mínima no puede ser mayor a 20")
    private Integer longitudMin;
    
    @NotBlank(message = "El campo requiere mayúscula, no puede ser minuscula")
    @Size(min = 1, max = 1, message = "Debe ser solo un carácter (S o N)")
    @Pattern(regexp = "[SN]", message = "Solo se permite 'S' para Sí o 'N' para No")
    private String requiereMayuscula; 

    @NotBlank(message = "El campo requiere un número, no puede estar vacío")
    @Pattern(regexp = "[SN]", message = "Solo se permite 'S' o 'N'")
    private String requiereNumero;    

    @NotBlank(message = "El campo requiere un caracter especial, no puede estar vacío")
    @Pattern(regexp = "[SN]", message = "Solo se permite 'S' o 'N'")
    private String requiereEspecial;  

    @NotNull(message = "Los intentos máximos son obligatorios")
    @Min(value = 1, message = "Debe permitir al menos 1 intento")
    @Max(value = 10, message = "No puedes permitir más de 10 intentos por seguridad")
    private Integer intentosMaximos;

    @NotNull(message = "Los días de expiración son obligatorios")
    @Min(value = 0, message = "Los días de expiración no pueden ser negativos")
    private Integer diasExpiracion;

    @NotNull(message = "El historial de claves es obligatorio")
    @Min(value = 1, message = "Debe recordar al menos la clave actual")
    @Max(value = 10, message = "No se puede guardar un historial de más de 10 claves")
    private Integer historialClaves;

}
