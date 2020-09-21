package pe.edu.upc.medicenter.services;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.medicenter.models.entities.Usuario;

public interface UsuarioService extends CrudService<Usuario, Integer>{
	List<Usuario> findByNombres(String nombres) throws Exception;
	Optional<Usuario> findByDNI(String dni) throws Exception;
}
