package pe.edu.upc.medicenter.repositories;

import java.util.List;

import pe.edu.upc.medicenter.models.entities.Clinica;

public interface ClinicaRepository extends JpaRepository<Clinica,Integer> {
	List<Clinica> findByNombre(String nombres) throws Exception;
	List<Clinica> findByUbicacion(String ubicacion) throws Exception;
	
}
