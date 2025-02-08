package com.example.Pasteletia.Service;

import java.util.List;
import java.util.Optional;

import com.example.Pasteletia.Entity.ClienteEntity;

public interface ClienteService {

	// Método para registrar un usuario
    ClienteEntity registrarUsuario(ClienteEntity usuario);

    // Método para obtener todos los usuarios
    List<ClienteEntity> obtenerTodosLosUsuarios();

    // Método para encontrar un usuario por su username
    Optional<ClienteEntity> obtenerUsuarioPorUsername(Long id);

	List<ClienteEntity> getAllUsuarios();
	
	void eliminarCliente (Long id);
}
