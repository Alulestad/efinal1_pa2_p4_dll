package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.ICitaMedicaRepo;
import com.example.demo.repo.IDoctorRepo;
import com.example.demo.repo.IPacienteRepo;
import com.example.demo.repo.modelo.CitaMedica;
import com.example.demo.repo.modelo.Doctor;
import com.example.demo.repo.modelo.Paciente;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	@Autowired
	private ICitaMedicaRepo iCitaMedicaRepo;

	@Autowired
	private IPacienteRepo iPacienteRepo;

	@Autowired
	private IDoctorRepo iDoctorRepo;

	@Override
	public void ingresar(String numeroCita, LocalDateTime fechaCita, BigDecimal valor, String lugar,
			String cedulaDoctor, String cedulaPaciente) {
		System.out.println("doc1");
		Doctor doctorParaCita = this.iDoctorRepo.seleccionarPorCedula(cedulaDoctor);
		System.out.println("doc1");
		Paciente pacienteParaCita = this.iPacienteRepo.seleccionarPorCedula(cedulaPaciente);
		
		CitaMedica nuevaCitaMedica= new CitaMedica();
		nuevaCitaMedica.setDiagnostico(null);
		nuevaCitaMedica.setDoctor(doctorParaCita);//OJO
		nuevaCitaMedica.setFechaCita(fechaCita);
		nuevaCitaMedica.setFechaProximaCita(null);
		nuevaCitaMedica.setLugar(lugar);
		nuevaCitaMedica.setNumeroCita(numeroCita);
		nuevaCitaMedica.setPaciente(pacienteParaCita); //Ojo
		nuevaCitaMedica.setReceta(null);
		nuevaCitaMedica.setValor(valor);
		
		List<CitaMedica> citasMedicas= new ArrayList<>();
		citasMedicas.add(nuevaCitaMedica);
		
		doctorParaCita.setCitasMedicas(citasMedicas);
		pacienteParaCita.setCitasMedicas(citasMedicas);
		
		System.out.println("33");
		this.iCitaMedicaRepo.insertar(nuevaCitaMedica);
		
		
		
		
	}

	@Override
	public CitaMedica buscarPorNumeroCita(String numeroCita) {
		// TODO Auto-generated method stub
		return this.iCitaMedicaRepo.seleccionarPorNumeroCita(numeroCita);
	}

	@Override
	public void actualizar(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		CitaMedica citaMedicaDesactualizada= this.iCitaMedicaRepo.seleccionarPorNumeroCita(numeroCita);

		CitaMedica citaMedicaActualizada= new CitaMedica();
		citaMedicaActualizada.setDiagnostico(diagnostico);
		citaMedicaActualizada.setDoctor(citaMedicaDesactualizada.getDoctor());
		citaMedicaActualizada.setFechaCita(citaMedicaDesactualizada.getFechaCita());
		citaMedicaActualizada.setFechaProximaCita(fechaProximaCita);
		citaMedicaActualizada.setId(citaMedicaDesactualizada.getId());
		citaMedicaActualizada.setLugar(citaMedicaDesactualizada.getLugar());
		citaMedicaActualizada.setNumeroCita(numeroCita);
		citaMedicaActualizada.setPaciente(citaMedicaDesactualizada.getPaciente());
		citaMedicaActualizada.setReceta(receta);
		citaMedicaActualizada.setValor(citaMedicaDesactualizada.getValor());
		
		this.iCitaMedicaRepo.actualizar(citaMedicaActualizada);

	}

}
