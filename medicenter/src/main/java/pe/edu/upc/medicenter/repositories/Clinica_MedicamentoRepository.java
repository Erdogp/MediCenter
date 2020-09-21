package pe.edu.upc.medicenter.repositories;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.medicenter.models.entities.Clinica_Medicamento;

public interface Clinica_MedicamentoRepository extends JpaRepository<Clinica_Medicamento,Integer> {
	List<Clinica_Medicamento> findByNombreMedicamento(String nombreMedicamento) throws Exception;
	List<Clinica_Medicamento> findByNombreClinica(String nombreClinica) throws Exception;
	Optional<Clinica_Medicamento> findById(Integer id) throws Exception;
}