package pe.edu.upc.medicenter.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.edu.upc.medicenter.models.entities.MedicamentosXClinica;
import pe.edu.upc.medicenter.repositories.MedXclinicaRepository;
import pe.edu.upc.medicenter.services.MedXClinicaService;

public class MedXClinicaServiceImpl implements MedXClinicaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private MedXclinicaRepository medRepository;
	@Transactional
	@Override
	public MedicamentosXClinica save(MedicamentosXClinica entity) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.save(entity);
	}

	@Override
	public MedicamentosXClinica update(MedicamentosXClinica entity) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.update(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		medRepository.deleteById(id);
	}

	@Override
	public List<MedicamentosXClinica> findAll() throws Exception {
		// TODO Auto-generated method stub
		return medRepository.findAll();
	}

	@Override
	public Optional<MedicamentosXClinica> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.findById(id);
	}

	@Override
	public List<MedicamentosXClinica> findByMedicamento(Integer idMedic) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.findByMedicamento(idMedic);
	}

	@Override
	public List<MedicamentosXClinica> findByClinica(Integer idClinica) throws Exception {
		// TODO Auto-generated method stub
		return medRepository.findByClinica(idClinica);
	}

}
