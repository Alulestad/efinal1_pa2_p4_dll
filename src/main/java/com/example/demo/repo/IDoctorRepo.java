package com.example.demo.repo;

import javax.print.Doc;

import com.example.demo.repo.modelo.Doctor;

public interface IDoctorRepo {
	//CREATE READ UPDATE DELETE
	
	public void insertar(Doctor doctor);
	public Doctor seleccionarPorId(Integer id);
	public void actualizar(Doctor doctor);
	public void eliminarPorId(Integer id);
	
	
	public Doctor seleccionarPorCedula(String cedula);
	

}
