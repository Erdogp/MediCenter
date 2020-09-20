package pe.edu.upc.medicenter.repositories;

import java.util.Optional;

import pe.edu.upc.medicenter.models.entities.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento,Integer>{
	Optional<Medicamento> findByNombre(String nombre) throws Exception;	
}
