package pe.edu.upc.medicenter.repositories;

import java.util.List;

import pe.edu.upc.medicenter.models.entities.Especialidad;

public interface EspecialidadRepository extends JpaRepository<Especialidad,Integer>{
	List<Especialidad> findByNombre (String nombre) throws Exception;
}
