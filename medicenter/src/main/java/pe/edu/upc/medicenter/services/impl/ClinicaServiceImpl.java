package pe.edu.upc.medicenter.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.edu.upc.medicenter.models.entities.Clinica;
import pe.edu.upc.medicenter.repositories.ClinicaRepository;
import pe.edu.upc.medicenter.services.ClinicaService;

public class ClinicaServiceImpl implements ClinicaService,Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Inject
	private ClinicaRepository clinicaRepository;

	@Transactional
	@Override
	public Clinica save(Clinica entity) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.save(entity);
	}

	@Transactional
	@Override
	public Clinica update(Clinica entity) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		clinicaRepository.deleteById(id);
	}

	@Override
	public List<Clinica> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.findAll();
	}

	@Override
	public List<Clinica> findByNombre(String nombres) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.findByNombre(nombres);
	}

	@Override
	public List<Clinica> findByUbicacion(String ubicacion) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.findByUbicacion(ubicacion);
	}

	@Override
	public Optional<Clinica> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clinicaRepository.findById(id);
	}
}
