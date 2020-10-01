package pe.edu.upc.medicenter.services;

import java.util.List;

import pe.edu.upc.medicenter.models.entities.Medicamento;

public interface MedicamentosService extends CrudService<Medicamento, Integer>{
	List<Medicamento> findByNombre(String nombre) throws Exception;
}
