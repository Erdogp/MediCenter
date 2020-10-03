package pe.edu.upc.medicenter.services;

import java.util.List;

import pe.edu.upc.medicenter.models.entities.Historial_Clinico;

public interface Historial_ClinicoService extends CrudService<Historial_Clinico, Integer> {
	
	List<Historial_Clinico> findByCita(Integer idCita) throws Exception;
}
