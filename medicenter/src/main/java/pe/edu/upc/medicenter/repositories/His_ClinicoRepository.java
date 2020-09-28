package pe.edu.upc.medicenter.repositories;

import java.util.List;

import pe.edu.upc.medicenter.models.entities.Historial_Clinico;

public interface His_ClinicoRepository extends JpaRepository<Historial_Clinico,Integer>{
	List<Historial_Clinico> findByCita(Integer idCita) throws Exception;
}
