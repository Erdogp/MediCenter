package pe.edu.upc.medicenter.repositories;

import java.util.List;

import pe.edu.upc.medicenter.models.entities.MedicamentosXClinica;

public interface MedXclinicaRepository extends JpaRepository<MedicamentosXClinica,Integer>{
	List<MedicamentosXClinica> findByMedicamento(Integer idMedic) throws Exception;
	List<MedicamentosXClinica> findByClinica(Integer idClinica) throws Exception;
}
