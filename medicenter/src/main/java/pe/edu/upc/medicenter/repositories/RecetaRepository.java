package pe.edu.upc.medicenter.repositories;

import java.util.List;

import pe.edu.upc.medicenter.models.entities.Receta;

public interface RecetaRepository extends JpaRepository<Receta,Integer> {
	List<Receta> findByHistorial(Integer idH_Clinico) throws Exception;
}
