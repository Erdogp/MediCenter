package pe.edu.upc.medicenter.repositories;

import java.util.Optional;

import pe.edu.upc.medicenter.models.entities.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{
	Optional<TipoUsuario> findByID(Integer id) throws Exception; 

}
