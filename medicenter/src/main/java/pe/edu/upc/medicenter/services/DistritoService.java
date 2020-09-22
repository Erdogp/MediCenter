package pe.edu.upc.medicenter.services;

import java.util.Optional;

import pe.edu.upc.medicenter.models.entities.Distrito;

public interface DistritoService extends CrudService<Distrito, Integer>{
	Optional<Distrito> findByNombre(String nombre) throws Exception;
}
