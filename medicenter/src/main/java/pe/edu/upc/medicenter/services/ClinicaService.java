package pe.edu.upc.medicenter.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.medicenter.models.entities.Clinica;

public interface ClinicaService extends CrudService<Clinica, Integer>{
	List<Clinica> findByNombre(String nombres) throws Exception;
	List<Clinica> findByUbicacion(String ubicacion) throws Exception;
	Optional<Clinica> findById(Integer id) throws Exception;
}
