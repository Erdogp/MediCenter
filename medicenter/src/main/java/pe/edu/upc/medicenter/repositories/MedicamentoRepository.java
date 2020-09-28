package pe.edu.upc.medicenter.repositories;

import java.util.List;

import pe.edu.upc.medicenter.models.entities.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento,Integer>{
	List<Medicamento> findByNombre(String nombre) throws Exception;	
}
