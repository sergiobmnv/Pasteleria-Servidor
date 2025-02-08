package com.example.Pasteletia.Service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pasteletia.Entity.EmpleadoEntity;
import com.example.Pasteletia.Model.EmpleadoDTO;
import com.example.Pasteletia.Repository.EmpleadoRepository;
import com.example.Pasteletia.Service.EmpleadoService;

@Service
public class EmpleadoServiceImplement implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public void registrarEmpleado(EmpleadoDTO empleadoDTO) {
        
        EmpleadoEntity empleadoEntity = new EmpleadoEntity();
        empleadoEntity.setUsername(empleadoDTO.getUsername());
        empleadoEntity.setPassword(empleadoDTO.getPassword());
        empleadoEntity.setNombre(empleadoDTO.getNombre());
        empleadoEntity.setApellido(empleadoDTO.getApellido());
        empleadoEntity.setTelefono(empleadoDTO.getTelefono());
        empleadoEntity.setFecha_contratacion(empleadoDTO.getFecha_Contratacion());
        empleadoEntity.setTipo(empleadoDTO.getTipo_Empleado());

        
        empleadoRepository.save(empleadoEntity);
    }

    @Override
    public List<EmpleadoDTO> listarEmpleados() {
        List<EmpleadoEntity> empleadosEntity = empleadoRepository.findAll();
        List<EmpleadoDTO> empleadosDTO = new ArrayList<>();

        // Convertir cada entidad de empleado a DTO
        for (EmpleadoEntity empleadoEntity : empleadosEntity) {
            EmpleadoDTO empleadoDTO = new EmpleadoDTO();
            empleadoDTO.setId(empleadoEntity.getId());
            empleadoDTO.setUsername(empleadoEntity.getUsername());
            empleadoDTO.setPassword(empleadoEntity.getPassword());
            empleadoDTO.setNombre(empleadoEntity.getNombre());
            empleadoDTO.setApellido(empleadoEntity.getApellido());
            empleadoDTO.setTelefono(empleadoEntity.getTelefono());
            empleadoDTO.setFecha_Contratacion(empleadoEntity.getFecha_contratacion());
            empleadoDTO.setTipo_Empleado(empleadoEntity.getTipo());

            
            empleadosDTO.add(empleadoDTO);
        }

        return empleadosDTO;
    }

    @Override
    public Optional<EmpleadoDTO> obtenerEmpleadoPorId(Long id) {
        Optional<EmpleadoEntity> empleadoEntityOpt = empleadoRepository.findById(id);
        if (empleadoEntityOpt.isPresent()) {
           
            EmpleadoEntity empleadoEntity = empleadoEntityOpt.get();
            EmpleadoDTO empleadoDTO = new EmpleadoDTO();
            empleadoDTO.setId(empleadoEntity.getId());
            empleadoDTO.setUsername(empleadoEntity.getUsername());
            empleadoDTO.setPassword(empleadoEntity.getPassword());
            empleadoDTO.setNombre(empleadoEntity.getNombre());
            empleadoDTO.setApellido(empleadoEntity.getApellido());
            empleadoDTO.setTelefono(empleadoEntity.getTelefono());
            empleadoDTO.setFecha_Contratacion(empleadoEntity.getFecha_contratacion());
            empleadoDTO.setTipo_Empleado(empleadoEntity.getTipo());

            return Optional.of(empleadoDTO);
        } else {
            return Optional.empty();
        }
    }
}
