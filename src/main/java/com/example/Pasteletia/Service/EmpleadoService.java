package com.example.Pasteletia.Service;

import java.util.List;
import java.util.Optional;

import com.example.Pasteletia.Model.EmpleadoDTO;

public interface EmpleadoService {

	void registrarEmpleado(EmpleadoDTO empleadoDTO); // Registrar un nuevo empleado

    List<EmpleadoDTO> listarEmpleados(); // Obtener todos los empleados

    Optional<EmpleadoDTO> obtenerEmpleadoPorId(Long id); // Buscar un empleado por ID

}