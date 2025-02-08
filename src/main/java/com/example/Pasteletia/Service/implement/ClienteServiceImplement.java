package com.example.Pasteletia.Service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pasteletia.Entity.ClienteEntity;
import com.example.Pasteletia.Repository.ClienteRepository;
import com.example.Pasteletia.Service.ClienteService;

@Service
public class ClienteServiceImplement  implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
    @Override
    public ClienteEntity registrarUsuario(ClienteEntity usuario) {
        return clienteRepository.save(usuario);
    }

    @Override
    public List<ClienteEntity> obtenerTodosLosUsuarios() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<ClienteEntity> obtenerUsuarioPorUsername(Long id) {
        return clienteRepository.findById(id);
    }

	@Override
	public List<ClienteEntity> getAllUsuarios() {
		return clienteRepository.findAll();
	}
	
	
	// Eliminar un cliente por ID
    @Override
    public void eliminarCliente(Long id) {
		// Llama al repositorio para eliminar el cliente por ID
    	clienteRepository.deleteById(id);
    }
    
    
    
    
}