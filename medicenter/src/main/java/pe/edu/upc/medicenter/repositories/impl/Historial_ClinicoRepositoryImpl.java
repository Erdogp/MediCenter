package pe.edu.upc.medicenter.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import pe.edu.upc.medicenter.models.entities.Historial_Clinico;
import pe.edu.upc.medicenter.repositories.Historial_ClinicoRepository;

@Named
public class Historial_ClinicoRepositoryImpl implements Historial_ClinicoRepository, Serializable {
   
	
	/**
	 * 
	 */
	@PersistenceContext (unitName = "MediCenterPU") 
	private static final long serialVersionUID = 1L;
	private EntityManager em;

	@Override
	public Historial_Clinico save(Historial_Clinico entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Override
	public Historial_Clinico update(Historial_Clinico entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(entity);
		
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Historial_Clinico> optional = findById(id);
		if(optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<Historial_Clinico> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Historial_Clinico> hisClinico = new ArrayList<Historial_Clinico>();
		String qlString = "SELECT c FROM Historial_Clinico c";
		TypedQuery<Historial_Clinico> query = em.createQuery(qlString , Historial_Clinico.class);
		hisClinico = query.getResultList();
		return hisClinico;
	}

	@Override
	public Optional<Historial_Clinico> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Historial_Clinico> hisClinico = Optional.empty();
		String qlString = "SELECT c FROM Historial_Clinico c WHERE c.id = ?1 ";
		TypedQuery<Historial_Clinico> query = em.createQuery(qlString, Historial_Clinico.class);
		query.setParameter(1, id);
		List<Historial_Clinico> his_clinicos = query.getResultList();
		if(his_clinicos != null && !his_clinicos.isEmpty())
			hisClinico = Optional.of(his_clinicos.get(0));
		
		return hisClinico;
	}

	@Override
	public Optional<Historial_Clinico> findByAlergia(String alergia) throws Exception {
		// TODO Auto-generated method stub
		Optional<Historial_Clinico> hisClinico = Optional.empty();
		String qlString = "SELECT c FROM Historial_Clinico c WHERE c.alergia = ?1 ";
		TypedQuery<Historial_Clinico> query = em.createQuery(qlString, Historial_Clinico.class);
		query.setParameter(1, alergia);
		List<Historial_Clinico> his_clinicos = query.getResultList();
		if(his_clinicos != null && !his_clinicos.isEmpty())
			hisClinico = Optional.of(his_clinicos.get(0));
		
		return hisClinico;
	}

}
