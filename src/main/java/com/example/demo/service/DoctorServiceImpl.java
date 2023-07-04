package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IDoctorRepo;
import com.example.demo.repo.modelo.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo iDoctorRepo;
	
	@Override
	public void agregar(Doctor doctor) {
		this.iDoctorRepo.insertar(doctor);

	}

	@Override
	public Doctor buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iDoctorRepo.seleccionarPorId(id);
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.iDoctorRepo.actualizar(doctor);
	}

	@Override
	public void borrarPorId(Integer id) {
		// TODO Auto-generated method stub
		this.iDoctorRepo.eliminarPorId(id);
	}

	@Override
	public Doctor buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iDoctorRepo.seleccionarPorCedula(cedula);
	}
	
	

}
