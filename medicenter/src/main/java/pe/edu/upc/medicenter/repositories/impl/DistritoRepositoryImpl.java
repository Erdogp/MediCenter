package pe.edu.upc.medicenter.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



import pe.edu.upc.medicenter.models.entities.Distrito;
import pe.edu.upc.medicenter.repositories.DistritoRepository;


public class DistritoRepositoryImpl implements DistritoRepository, Serializable{


	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "MedicenterPU")
	private EntityManager em;
	
	@Override
	public Distrito save(Distrito entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Distrito update(Distrito entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Distrito> optional=findById(id);
		if(optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<Distrito> findAll() throws Exception {
		List<Distrito> distritos = new ArrayList<Distrito>();
		String qlString = "SELECT c FROM Distrito c";	// JPQL
		TypedQuery<Distrito> query = em.createQuery(qlString, Distrito.class);
		distritos = query.getResultList();
		return distritos;
	}

	@Override
	public Optional<Distrito> findById(Integer id) throws Exception {
		Optional<Distrito> distrito = Optional.empty();
		String qlString = "SELECT c FROM Distrito c WHERE c.id = ?1";	// JPQL
		TypedQuery<Distrito> query = em.createQuery(qlString, Distrito.class);
		query.setParameter(1, id);
		List<Distrito> distritos = query.getResultList();
		
		if(distritos != null && !distritos.isEmpty())
			distrito = Optional.of( distritos.get(0) );
		
		return distrito;
	}

	@Override
	public Optional<Distrito> findByNombre(String nombre) throws Exception {
		Optional<Distrito> distrito = Optional.empty();
		String qlString = "SELECT c FROM Distrito c WHERE c.nombre = ?1";	// JPQL
		TypedQuery<Distrito> query = em.createQuery(qlString, Distrito.class);
		query.setParameter(1, nombre);
		List<Distrito> distritos = query.getResultList();
		
		if(distritos != null && !distritos.isEmpty())
			distrito = Optional.of( distritos.get(0) );
		
		return distrito;
	}

}
