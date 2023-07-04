package com.example.demo.service;

import com.example.demo.repo.modelo.Paciente;

public interface IPacienteService {

	public void agregar(Paciente paciente);
	public Paciente buscarPorId(Integer id);
	public void actualizar(Paciente paciente);
	
	
	public Paciente buscarPorCedula(String cedula);
}
