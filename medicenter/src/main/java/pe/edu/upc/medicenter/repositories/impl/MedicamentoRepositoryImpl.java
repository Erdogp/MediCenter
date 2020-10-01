package pe.edu.upc.medicenter.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.medicenter.models.entities.Medicamento;
import pe.edu.upc.medicenter.repositories.MedicamentoRepository;

public class MedicamentoRepositoryImpl implements MedicamentoRepository, Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "MedicenterPU")
	private EntityManager em;
	
	@Override
	public Medicamento save(Medicamento entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Medicamento update(Medicamento entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Medicamento> optional=findById(id);
		if(optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<Medicamento> findAll() throws Exception {
		List<Medicamento> medicamentos = new ArrayList<Medicamento>();
		String qlString = "SELECT c FROM Medicamento c";	// JPQL
		TypedQuery<Medicamento> query = em.createQuery(qlString, Medicamento.class);
		medicamentos = query.getResultList();
		return medicamentos;
	}

	@Override
	public Optional<Medicamento> findById(Integer id) throws Exception {
		Optional<Medicamento> medicamento = Optional.empty();
		String qlString = "SELECT c FROM Medicamento c WHERE c.Id = ?1";	// JPQL
		TypedQuery<Medicamento> query = em.createQuery(qlString, Medicamento.class);
		query.setParameter(1, id);
		List<Medicamento> Medicamentos = query.getResultList();
		
		if(Medicamentos!= null && !Medicamentos.isEmpty())
			medicamento = Optional.of( Medicamentos.get(0) );
		
		return medicamento;
	}

	@Override
	public List<Medicamento> findByNombre(String nombre) throws Exception {
		List<Medicamento> Usuarios = new ArrayList<Medicamento>();
		String qlString = "SELECT c FROM Medicamento c WHERE c.nombre LIKE '%?1%'";	// JPQL
		TypedQuery<Medicamento> query = em.createQuery(qlString, Medicamento.class);
		query.setParameter(1, nombre);
		Usuarios = query.getResultList();
		return Usuarios;
	}
		
}
