package com.example.demo.repo;

import com.example.demo.repo.modelo.Doctor;
import com.example.demo.repo.modelo.Paciente;

public interface IPacienteRepo {
	
	public void insertar(Paciente paciente);
	public Paciente seleccionarPorId(Integer id);
	public void actualizar(Paciente paciente);
	
	
	public Paciente seleccionarPorCedula(String cedula);
	
}
