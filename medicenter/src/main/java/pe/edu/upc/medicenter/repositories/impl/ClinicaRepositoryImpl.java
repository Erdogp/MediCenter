package pe.edu.upc.medicenter.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import pe.edu.upc.medicenter.models.entities.Clinica;
import pe.edu.upc.medicenter.repositories.ClinicaRepository;
import pe.edu.upc.medicenter.services.DistritoService;

public class ClinicaRepositoryImpl implements ClinicaRepository,Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DistritoService disService;
	
	@PersistenceContext(unitName = "MedicenterPU")
	private EntityManager em;
	
	@Override
	public Clinica save(Clinica entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Clinica update(Clinica entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Clinica> optional=findById(id);
		if(optional.isPresent())
			em.remove(optional.get());
				
	}

	@Override
	public List<Clinica> findAll() throws Exception {
		List<Clinica> clinicas = new ArrayList<Clinica>();
		//String qlString = "SELECT c.idC,c.nombrec,c.ubicacion,c.horario,b.nombre FROM Clinica c join distritos b on b.id=c.distrito_id";	// JPQL
		String qlString ="select c from Clinica c";
		TypedQuery<Clinica> query = em.createQuery(qlString, Clinica.class);
		clinicas = query.getResultList();
		for (Clinica cli :clinicas)
		{	
			cli.setDistrito(disService.findById(cli.getDistrito().getId()).get());
		}
		return clinicas;
	}

	@Override
	public List<Clinica> findByNombre(String nombres) throws Exception {
		List<Clinica> clinicas = new ArrayList<Clinica>();
		String qlString = "SELECT c FROM Clinica c WHERE c.nombrec LIKE '%?1%'";	// JPQL
		TypedQuery<Clinica> query = em.createQuery(qlString, Clinica.class);
		query.setParameter(1, nombres);
		clinicas = query.getResultList();
		return clinicas;
	}

	@Override
	public List<Clinica> findByUbicacion(String ubicacion) throws Exception {
		List<Clinica> clinicas = new ArrayList<Clinica>();
		String qlString = "SELECT c FROM Clinica c WHERE c.ubicacion LIKE '%?1%'";	// JPQL
		TypedQuery<Clinica> query = em.createQuery(qlString, Clinica.class);
		query.setParameter(1, ubicacion);
		clinicas = query.getResultList();
		return clinicas;
	}

	@Override
	public Optional<Clinica> findById(Integer id) throws Exception {
		Optional<Clinica> clinica = Optional.empty();
		String qlString = "SELECT c FROM Clinica c WHERE c.idC = ?1";	// JPQL
		TypedQuery<Clinica> query = em.createQuery(qlString, Clinica.class);
		query.setParameter(1, id);
		List<Clinica> clinicas = query.getResultList();
		
		if(clinicas != null && !clinicas.isEmpty())
			clinica = Optional.of( clinicas.get(0) );
		
		return clinica;
	}

}
