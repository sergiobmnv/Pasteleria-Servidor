package com.example.Pasteletia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Pasteletia.Entity.ClienteEntity;
import com.example.Pasteletia.Service.ClienteService;


@Controller
@RequestMapping("/usuarios")
public class ClienteController {

	@Autowired
	private ClienteService usuarioService;

	@GetMapping("/registroCliente")
	public String mostrarFormularioRegistro(Model model) {
	    model.addAttribute("usuario", new ClienteEntity());
	    return "registroCliente";
	}

	@PostMapping("/procesarCliente")
	public String procesarRegistro(@ModelAttribute ClienteEntity usuario, Model model) {
	    usuarioService.registrarUsuario(usuario); //Guarda el UsuarioEntity en la base de datos
	    model.addAttribute("mensaje", "Usuario registrado exitosamente");
	    model.addAttribute("usuario", new ClienteEntity()); // Reiniciar el formulario
	    return "registroCliente";
	}

	// Mostrar lista de usuarios
	@GetMapping("/lista")
	public String listarUsuarios(Model model) {
		 List<ClienteEntity> usuarios = usuarioService.getAllUsuarios();
		 model.addAttribute("usuarios", usuarios);
		 return "listaUsuarios";
	}
	
	// Eliminar un cliente
    @PostMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        usuarioService.eliminarCliente(id);
        return "redirect:/usuarios/lista";
    }
}