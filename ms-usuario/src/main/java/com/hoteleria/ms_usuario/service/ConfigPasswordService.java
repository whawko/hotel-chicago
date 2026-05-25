package com.hoteleria.ms_usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.hoteleria.ms_usuario.dto.ConfigPasswordRequestDTO;
import com.hoteleria.ms_usuario.dto.ConfigPasswordResponseDTO;
import com.hoteleria.ms_usuario.dto.LogRequestDTO;
import com.hoteleria.ms_usuario.model.ConfigPassword;
import com.hoteleria.ms_usuario.repository.ConfigPasswordRepository;

@Service
public class ConfigPasswordService {
    @Autowired
    private ConfigPasswordRepository configRepository;
    
    // 1. Inyectas el cliente HTTP que ya configuramos en la carpeta config
    @Autowired
    private WebClient webClientAuditoria; 

    // MÉTODO: Guardar o Actualizar la configuración
    public ConfigPasswordResponseDTO guardarConfiguracion(ConfigPasswordRequestDTO dto) {
        // Buscamos la configuración única (ID 1). Si no existe, creamos una nueva.
        ConfigPassword config = configRepository.findById(1L)
                .orElse(new ConfigPassword());

        // Mapeamos los datos del DTO a la Entidad (Lo que ya tenías)
        config.setId(1L); 
        config.setLongitudMin(dto.getLongitudMin());
        config.setRequiereMayuscula(dto.getRequiereMayuscula());
        config.setRequiereNumero(dto.getRequiereNumero());
        config.setRequiereEspecial(dto.getRequiereEspecial());
        config.setIntentosMaximos(dto.getIntentosMaximos());
        config.setDiasExpiracion(dto.getDiasExpiracion());
        config.setHistorialClaves(dto.getHistorialClaves());

        // Guardamos en la base de datos local
        ConfigPassword guardado = configRepository.save(config);

        // ==========================================
        // 2. ¡AQUÍ ENTRA EL BLOQUE DEL WEBCLIENT!
        // ==========================================
        try {
            LogRequestDTO logDto = new LogRequestDTO();
            logDto.setUsuarioId(1L); // Aquí iría el ID del administrador logueado
            logDto.setAccion("Modificó la política de contraseñas globales");
            logDto.setIpOrigen("192.168.1.10"); // IP del cliente que hizo el cambio

            // Hacemos el envío rápido por HTTP POST en segundo plano
            webClientAuditoria.post()
                    .bodyValue(logDto)
                    .retrieve()
                    .toBodilessEntity()
                    .subscribe(); // Se dispara de forma asíncrona
        } catch (Exception e) {
            // Si el servicio de auditoría está apagado, atrapamos el error 
            // para que el Administrador sí pueda guardar su configuración sin problemas
            System.err.println("No se pudo conectar con el Microservicio de Auditoría: " + e.getMessage());
        }

        // Retornamos el ResponseDTO al controlador (Lo que ya tenías)
        return convertirADTO(guardado);
    }

    // MÉTODO: Obtener la configuración actual (Lo que ya tenías)
    public ConfigPasswordResponseDTO obtenerConfiguracion() {
        ConfigPassword config = configRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Aún no hay una configuración definida."));
        return convertirADTO(config);
    }

    // MÉTODO PRIVADO: Conversión a DTO (Lo que ya tenías)
    private ConfigPasswordResponseDTO convertirADTO(ConfigPassword entidad) {
        ConfigPasswordResponseDTO dto = new ConfigPasswordResponseDTO();
        dto.setId(entidad.getId());
        dto.setLongitudMin(entidad.getLongitudMin());
        dto.setRequiereMayuscula(entidad.getRequiereMayuscula());
        dto.setRequiereNumero(entidad.getRequiereNumero());
        dto.setRequiereEspecial(entidad.getRequiereEspecial());
        dto.setIntentosMaximos(entidad.getIntentosMaximos());
        dto.setDiasExpiracion(entidad.getDiasExpiracion());
        dto.setHistorialClaves(entidad.getHistorialClaves());
        return dto;
    }
}

