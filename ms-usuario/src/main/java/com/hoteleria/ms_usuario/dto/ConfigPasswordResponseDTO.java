package com.hoteleria.ms_usuario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfigPasswordResponseDTO {
    private Long id;
    private Integer longitudMin;
    private String requiereMayuscula;
    private String requiereNumero;
    private String requiereEspecial;
    private Integer intentosMaximos;
    private Integer diasExpiracion;
    private Integer historialClaves;
}
