package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.modelo.Doctor;
import com.example.demo.repo.modelo.Paciente;
import com.example.demo.service.ICitaMedicaService;
import com.example.demo.service.IDoctorService;
import com.example.demo.service.IPacienteService;

@SpringBootApplication
public class Efinal1Pa2P4Dll2Application implements CommandLineRunner{

	@Autowired
	private IPacienteService iPacienteService;
	
	@Autowired
	private IDoctorService iDoctorService;
	
	@Autowired
	private ICitaMedicaService iCitaMedicaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Efinal1Pa2P4Dll2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Paciente paciente1 = new Paciente();
		paciente1.setApellido("Molina");
		paciente1.setCedula("12345");
		paciente1.setCodigoSeguro("12345");
		paciente1.setEstatura(Double.valueOf(165));
		paciente1.setFechaNacimiento(LocalDateTime.now());
		paciente1.setGenero("M");
		paciente1.setNombre("Daniele");
		paciente1.setPeso(Double.valueOf(75));
		
		this.iPacienteService.agregar(paciente1);
		
		Doctor doctor1= new Doctor();
		doctor1.setApellido("Paez");
		doctor1.setCedula("123456");
		doctor1.setCodigoSenescyt("abcd");
		doctor1.setFechaNacimiento(LocalDateTime.now());
		doctor1.setGenero("M");
		doctor1.setNombre("Carlos");
		doctor1.setNumeroConsultorio("6");
		
		this.iDoctorService.agregar(doctor1);
		
		
		
		this.iCitaMedicaService.ingresar("7897899", LocalDateTime.now(), new BigDecimal(50),"Hospital Hermanas Solidarias" , "1234", "123");
		
		this.iCitaMedicaService.actualizar("789789","Gripe" , "paracetamol 100g", LocalDateTime.now());
		
		//System.out.println(this.iCitaMedicaService.buscarPorNumeroCita("789"));
		
		
	}

}
