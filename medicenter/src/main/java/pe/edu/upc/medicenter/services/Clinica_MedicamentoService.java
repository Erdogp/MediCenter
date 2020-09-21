package pe.edu.upc.medicenter.services;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.medicenter.models.entities.Clinica_Medicamento;

public interface Clinica_MedicamentoService extends CrudService<Clinica_Medicamento, Integer>{
	List<Clinica_Medicamento> findByNombreClinica(String nombreClinica) throws Exception;
	List<Clinica_Medicamento> findByNombreMedicamento(String nombreMedicamento) throws Exception;
	Optional<Clinica_Medicamento> findById(Integer id) throws Exception;
}
