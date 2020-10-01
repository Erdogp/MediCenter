package pe.edu.upc.medicenter.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.edu.upc.medicenter.models.entities.Medicamento;
import pe.edu.upc.medicenter.repositories.MedicamentoRepository;

import pe.edu.upc.medicenter.services.MedicamentosService;

public class MedicamentoServiceImpl implements MedicamentosService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private MedicamentoRepository medRepository;
	@Transactional
	@Override
	public Medicamento save(Medicamento entity) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.save(entity);
	}
	@Transactional
	@Override
	public Medicamento update(Medicamento entity) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.update(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		medRepository.deleteById(id);
	}

	@Override
	public List<Medicamento> findAll() throws Exception {
		// TODO Auto-generated method stub
		return medRepository.findAll();
	}

	@Override
	public Optional<Medicamento> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.findById(id);
	}

	@Override
	public List<Medicamento> findByNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.findByNombre(nombre);
	}

}
