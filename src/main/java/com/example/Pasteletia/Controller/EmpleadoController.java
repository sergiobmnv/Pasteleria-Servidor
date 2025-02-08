package com.example.Pasteletia.Controller;

import com.example.Pasteletia.Service.EmpleadoService;
import com.example.Pasteletia.Model.EmpleadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    // Ruta para ver el formulario de registro de empleado
    @GetMapping("/empleados/registroEmpleado")
    public String registrarEmpleadoForm(Model model) {
        model.addAttribute("empleado", new EmpleadoDTO()); // Pasar un objeto vacío para el formulario
        return "registroEmpleado"; // Devuelve el nombre de la vista Thymeleaf
    }

    // Ruta para registrar un nuevo empleado
    @PostMapping("/empleados/registroEmpleado")
    public String registrarEmpleado(EmpleadoDTO empleadoDTO) {
        empleadoService.registrarEmpleado(empleadoDTO); // Llamada al servicio para registrar al empleado
        return "/empleados/lista"; // Redirigir a la lista de empleados después de registrar
    }

    // Ruta para ver la lista de empleados
    @GetMapping("/empleados/lista")
    public String listarEmpleados(Model model) {
        List<EmpleadoDTO> empleados = empleadoService.listarEmpleados(); // Obtener la lista de empleados desde el servicio
        model.addAttribute("empleados", empleados); // Pasar la lista a la vista
        return "listaEmpleado"; // Devuelve el nombre de la vista Thymeleaf
    }

    // Ruta para ver los detalles de un empleado por ID (si lo deseas)
    @GetMapping("/empleados/detalles")
    public String obtenerEmpleadoPorId(@RequestParam("id") Long id, Model model) {
        Optional<EmpleadoDTO> empleado = empleadoService.obtenerEmpleadoPorId(id); // Buscar al empleado por ID
        if (empleado.isPresent()) {
            model.addAttribute("empleado", empleado.get()); // Pasar el empleado encontrado a la vista
            return "detallesEmpleado"; // Devuelve el nombre de la vista Thymeleaf para los detalles
        } else {
            return "/empleados/lista"; // Si no se encuentra el empleado, redirige a la lista
        }
    }
}
