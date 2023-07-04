package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.repo.modelo.CitaMedica;

@Service
public interface ICitaMedicaService {

	public void ingresar(String numeroCita, LocalDateTime fechaCita, BigDecimal valor, String lugar, String cedulaDoctor, String cedulaPaciente);
	public CitaMedica buscarPorNumeroCita(String numeroCita);
	public void actualizar(String numeroCita, String diagnostico, String receta,LocalDateTime fechaProximaCita );
	
}
