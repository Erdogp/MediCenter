package pe.edu.upc.medicenter.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.edu.upc.medicenter.models.entities.Distrito;
import pe.edu.upc.medicenter.repositories.DistritoRepository;
import pe.edu.upc.medicenter.services.DistritoService;

public class DistritoServiceImpl implements DistritoService, Serializable {


	private static final long serialVersionUID = 1L;
	
	@Inject
	private DistritoRepository distritoRepository;
	
	@Transactional
	@Override
	public Distrito save(Distrito entity) throws Exception {
		// TODO Auto-generated method stub
		return distritoRepository.save(entity);
	}
	@Transactional
	@Override
	public Distrito update(Distrito entity) throws Exception {
		// TODO Auto-generated method stub
		return distritoRepository.update(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		distritoRepository.deleteById(id);
	}

	@Override
	public List<Distrito> findAll() throws Exception {
		// TODO Auto-generated method stub
		return distritoRepository.findAll();
	}

	@Override
	public Optional<Distrito> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return distritoRepository.findById(id);
	}

	@Override
	public Optional<Distrito> findByNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return distritoRepository.findByNombre(nombre);
	}

}
