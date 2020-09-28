package pe.edu.upc.medicenter.repositories;

import java.util.List;

import pe.edu.upc.medicenter.models.entities.Cita;

public interface CitaRepository extends JpaRepository<Cita,Integer>{
	List<Cita> findByPacientes(Integer idPaciente) throws Exception;
	List<Cita> findByEspecialista(Integer idEspecialista) throws Exception;
}
