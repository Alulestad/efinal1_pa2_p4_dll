package com.example.demo.repo;

import com.example.demo.repo.modelo.CitaMedica;

public interface ICitaMedicaRepo {

	//select con numero de cita
	//actualizar
	
	
	public void insertar(CitaMedica citaMedica);
	public CitaMedica seleccionarPorNumeroCita(String numeroCita);
	public void actualizar(CitaMedica citaMedica);
	
	
}
