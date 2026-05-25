package com.hotel.foto.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class FotoRequestDTO {

    @NotBlank(message = "La URL de la foto es obligatoria")
    @Size(max = 250, message = "La URL no puede superar los 250 caracteres")
    private String url;

    @NotBlank(message = "Debe especificar si es portada ('SI' o 'NO')")
    @Pattern(regexp = "^(SI|NO)$", message = "El campo es portada solo acepta valores 'SI' o 'NO'")
    private String esPortada;

    @NotNull(message = "El ID de la habitación es obligatorio")
    private Long habitacionIdHab;
}