package pe.edu.upc.medicenter.repositories;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.medicenter.models.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
	List<Usuario> findByNombres(String nombres) throws Exception;
	Optional<Usuario> findByDNI(String dni) throws Exception;
}
