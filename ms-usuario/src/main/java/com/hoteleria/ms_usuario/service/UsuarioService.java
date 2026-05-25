package com.hoteleria.ms_usuario.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteleria.ms_usuario.model.Usuario;
import com.hoteleria.ms_usuario.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Verifica de forma rápida y ligera si un ID de usuario existe.
    public boolean existePorId(Long id) {
        return usuarioRepository.existsById(id);
    }

    //Devuelve la lista completa de usuarios registrados.
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    
    //Busca un usuario específico. Lanza una excepción si no lo encuentra.
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el ID: " + id));
    }

      //Guarda un nuevo usuario en la base de datos.
    public Usuario guardarUsuario(Usuario usuario) {
        // Aquí podrías agregar validaciones extra, como ver si el correo ya existe
        return usuarioRepository.save(usuario);
    }

    
    
     //Borra el registro de la base de datos mediante su ID.
    public void eliminarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar. Usuario no encontrado con el ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

}