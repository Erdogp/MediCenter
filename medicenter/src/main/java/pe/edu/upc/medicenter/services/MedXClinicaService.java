package pe.edu.upc.medicenter.services;

import java.util.List;

import pe.edu.upc.medicenter.models.entities.MedicamentosXClinica;

public interface MedXClinicaService extends CrudService<MedicamentosXClinica,Integer>{
	List<MedicamentosXClinica> findByMedicamento(Integer idMedic) throws Exception;
	List<MedicamentosXClinica> findByClinica(Integer idClinica) throws Exception;
}
