package com.example.Pasteletia.Model;

import java.sql.Date;

public class EmpleadoDTO {

	private Long id;
	private String username;
	private String password;
	private String nombre;
	private String apellido;
	private String telefono;
	//Falla en la fecha_contratacion.
	private Date fecha_Contratacion;
	private String tipo_Empleado;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getFecha_Contratacion() {
		return fecha_Contratacion;
	}
	public void setFecha_Contratacion(java.util.Date date) {
		this.fecha_Contratacion = (Date) date;
	}
	public String getTipo_Empleado() {
		return tipo_Empleado;
	}
	public void setTipo_Empleado(String tipo_Empleado) {
		this.tipo_Empleado = tipo_Empleado;
	}
	
}