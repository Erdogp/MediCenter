package pe.edu.upc.medicenter.repositories;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.medicenter.models.entities.Cita;

public interface CitaRepository extends JpaRepository<Cita,Integer> {
	List<Cita> findByNombrePaciente(String nombrePaciente) throws Exception;
	List<Cita> findByNombreEspecialista(String nombreEspecialista) throws Exception;
	Optional<Cita> findById(Integer id) throws Exception;
}
