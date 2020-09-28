package pe.edu.upc.medicenter.repositories;

import java.util.List;


import pe.edu.upc.medicenter.models.entities.Especialista;

public interface EspecialistaRepository extends JpaRepository<Especialista ,Integer>{
	List<Especialista> findByEspecialidad(String specialidad) throws Exception;
	List<Especialista> findByClinica(Integer idClinica) throws Exception;
}
