package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Doctor;
import com.example.demo.repo.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Paciente paciente) {
		this.entityManager.persist(paciente);

	}

	@Override
	public Paciente seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.entityManager.merge(paciente);

	}

	@Override
	public Paciente seleccionarPorCedula(String cedula) {
		TypedQuery<Paciente> myTypedQuery=this.entityManager.createQuery("select p from Paciente p where p.cedula=:datoCedula", Paciente.class);
		myTypedQuery.setParameter("datoCedula",cedula);
		
		
		return myTypedQuery.getSingleResult();
	}
	
	

}
