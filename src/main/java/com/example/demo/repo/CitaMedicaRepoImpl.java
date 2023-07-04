package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.CitaMedica;
import com.example.demo.repo.modelo.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CitaMedicaRepoImpl implements ICitaMedicaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	@Override
	public void insertar(CitaMedica citaMedica) {
		this.entityManager.persist(citaMedica);
		
	}

	@Override
	public CitaMedica seleccionarPorNumeroCita(String numeroCita) {
		TypedQuery<CitaMedica> myTypedQuery=this.entityManager.createQuery("select cm from CitaMedica cm where cm.numeroCita=:datoNumeroCita", CitaMedica.class);
		myTypedQuery.setParameter("datoNumeroCita",numeroCita);
		
		
		return myTypedQuery.getSingleResult();
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		this.entityManager.merge(citaMedica);

	}

}
