package pe.edu.upc.medicenter.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.medicenter.models.entities.MedicamentosXClinica;
import pe.edu.upc.medicenter.repositories.MedXclinicaRepository;
import pe.edu.upc.medicenter.services.ClinicaService;
import pe.edu.upc.medicenter.services.MedicamentosService;

public class MedXclinicaRepositoryImpl implements MedXclinicaRepository,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClinicaService cliService;
	@Inject
	private MedicamentosService medService;
	
	@PersistenceContext(unitName = "MedicenterPU")
	private EntityManager em;
	
	@Override
	public MedicamentosXClinica save(MedicamentosXClinica entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public MedicamentosXClinica update(MedicamentosXClinica entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<MedicamentosXClinica> optional=findById(id);
		if(optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<MedicamentosXClinica> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<MedicamentosXClinica> clinicas = new ArrayList<MedicamentosXClinica>();
		String qlString ="select c from MedicamentosXClinica c";
		TypedQuery<MedicamentosXClinica> query = em.createQuery(qlString, MedicamentosXClinica.class);
		clinicas = query.getResultList();
		for (MedicamentosXClinica cli :clinicas)
		{	
			cli.setClinica(cliService.findById(cli.getClinica().getIdC()).get());
			cli.setMedicamento(medService.findById(cli.getMedicamento().getId()).get());
		}
		return clinicas;
	}

	@Override
	public Optional<MedicamentosXClinica> findById(Integer id) throws Exception {
		Optional<MedicamentosXClinica> clinica = Optional.empty();
		String qlString = "SELECT c FROM MedicamentosXClinica c WHERE c.idMedClinica = ?1";	// JPQL
		TypedQuery<MedicamentosXClinica> query = em.createQuery(qlString, MedicamentosXClinica.class);
		query.setParameter(1, id);
		List<MedicamentosXClinica> clinicas = query.getResultList();
		
		if(clinicas != null && !clinicas.isEmpty())
			clinica = Optional.of( clinicas.get(0) );
		
		return clinica;
	}

	@Override
	public List<MedicamentosXClinica> findByMedicamento(Integer idMedic) throws Exception {
		List<MedicamentosXClinica> clinicas = new ArrayList<MedicamentosXClinica>();
		String qlString = "SELECT c FROM MedicamentosXClinica c WHERE c.medicamento.Id =?1";	// JPQL
		TypedQuery<MedicamentosXClinica> query = em.createQuery(qlString, MedicamentosXClinica.class);
		query.setParameter(1, idMedic);
		clinicas = query.getResultList();
		return clinicas;
	}

	@Override
	public List<MedicamentosXClinica> findByClinica(Integer idClinica) throws Exception {
		List<MedicamentosXClinica> clinicas = new ArrayList<MedicamentosXClinica>();
		String qlString = "SELECT c FROM MedicamentosXClinica c WHERE c.clinica.idC =?1";	// JPQL
		TypedQuery<MedicamentosXClinica> query = em.createQuery(qlString, MedicamentosXClinica.class);
		query.setParameter(1, idClinica);
		clinicas = query.getResultList();
		for (MedicamentosXClinica cli :clinicas)
		{	
			cli.setClinica(cliService.findById(cli.getClinica().getIdC()).get());
			cli.setMedicamento(medService.findById(cli.getMedicamento().getId()).get());
		}
		return clinicas;
	}

}
