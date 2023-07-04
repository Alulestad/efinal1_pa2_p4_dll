package com.example.demo.service;

import com.example.demo.repo.modelo.Doctor;

public interface IDoctorService {

	public void agregar(Doctor doctor);
	public Doctor buscarPorId(Integer id);
	public void actualizar(Doctor doctor);
	public void borrarPorId(Integer id);
	
	public Doctor buscarPorCedula(String cedula);
	
}
