package pe.edu.upc.medicenter.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.medicenter.models.entities.Historial_Clinico;
import pe.edu.upc.medicenter.repositories.His_ClinicoRepository;
import pe.edu.upc.medicenter.services.Historial_ClinicoService;

@Named
public class Historial_ClinicoServiceImpl implements Historial_ClinicoService, Serializable
{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private  His_ClinicoRepository hisClinicoRepository ;

	@Transactional
	@Override
	public Historial_Clinico save(Historial_Clinico entity) throws Exception {
		// TODO Auto-generated method stub
		return hisClinicoRepository.save(entity);
	}

	@Transactional
	@Override
	public Historial_Clinico update(Historial_Clinico entity) throws Exception {
		// TODO Auto-generated method stub
		return hisClinicoRepository.update(entity);
	}
	
	
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		hisClinicoRepository.deleteById(id);
	}

	@Override
	public List<Historial_Clinico> findAll() throws Exception {
		// TODO Auto-generated method stub
		return hisClinicoRepository.findAll();
	}

	@Transactional
	@Override
	public Optional<Historial_Clinico> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return hisClinicoRepository.findById(id);
	}

	@Transactional
	@Override
	public List<Historial_Clinico> findByCita(Integer idCita) throws Exception {
		// TODO Auto-generated method stub
		return hisClinicoRepository.findByCita(idCita);
	}

}
