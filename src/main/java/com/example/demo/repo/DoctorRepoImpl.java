package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DoctorRepoImpl implements IDoctorRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Doctor doctor) {
		this.entityManager.persist(doctor);

	}

	@Override
	public Doctor seleccionarPorId(Integer id) {
		
		
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void actualizar(Doctor doctor) {
		this.entityManager.merge(doctor);

	}

	@Override
	public void eliminarPorId(Integer id) {
		Doctor encontrado = this.seleccionarPorId(id);
		this.entityManager.remove(encontrado);

	}

	@Override
	public Doctor seleccionarPorCedula(String cedula) {
		TypedQuery<Doctor> myTypedQuery=this.entityManager.createQuery("select d from Doctor d where d.cedula=:datoCedula", Doctor.class);
		myTypedQuery.setParameter("datoCedula",cedula);
		
		
		return myTypedQuery.getSingleResult();
	}
	
	

}
