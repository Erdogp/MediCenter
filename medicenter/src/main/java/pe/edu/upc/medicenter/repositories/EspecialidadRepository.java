package pe.edu.upc.medicenter.repositories;

import java.util.Optional;

import pe.edu.upc.medicenter.models.entities.Especialidad;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {
	Optional<Especialidad> findByID(Integer id) throws Exception; 

}
