package pe.edu.upc.medicenter.repositories;

import java.util.Optional;

import pe.edu.upc.medicenter.models.entities.Distrito;

public interface DistritoRepository extends JpaRepository<Distrito,Integer>{
	Optional<Distrito> findByNombre(String nombre) throws Exception;	
}
