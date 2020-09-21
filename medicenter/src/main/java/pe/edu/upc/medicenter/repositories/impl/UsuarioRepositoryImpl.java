package pe.edu.upc.medicenter.repositories.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.medicenter.models.entities.Usuario;
import pe.edu.upc.medicenter.repositories.UsuarioRepository;

public class UsuarioRepositoryImpl implements UsuarioRepository, Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "MedicenterPU")
	private EntityManager em;
	
	@Override
	public Usuario save(Usuario entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Override
	public Usuario update(Usuario entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		Optional<Usuario> optional=findById(id);
		if(optional.isPresent())
			em.remove(optional.get());
				
	}

	@Override
	public List<Usuario> findAll() throws Exception {
		List<Usuario> Usuarios = new ArrayList<Usuario>();
		String qlString = "SELECT c FROM Usuario c";	// JPQL
		TypedQuery<Usuario> query = em.createQuery(qlString, Usuario.class);
		Usuarios = query.getResultList();
		return Usuarios;
	}

	@Override
	public List<Usuario> findByNombres(String nombres) throws Exception {
		List<Usuario> Usuarios = new ArrayList<Usuario>();
		String qlString = "SELECT c FROM Usuario c WHERE c.nombres LIKE '%?1%'";	// JPQL
		TypedQuery<Usuario> query = em.createQuery(qlString, Usuario.class);
		query.setParameter(1, nombres);
		Usuarios = query.getResultList();
		return Usuarios;
	}

	@Override
	public Optional<Usuario> findByDNI(String dni) throws Exception {
		Optional<Usuario> Usuarios =  Optional.empty();
		String qlString = "SELECT c FROM Usuario c WHERE c.dni LIKE '%?1%'";	// JPQL
		TypedQuery<Usuario> query = em.createQuery(qlString, Usuario.class);
		query.setParameter(1, dni);
		List<Usuario> usuari = query.getResultList();
		if (usuari !=null && !usuari.isEmpty())
			Usuarios=Optional.of(usuari.get(0));
		return Usuarios;
	}

	@Override
	public Optional<Usuario> findById(Integer id) throws Exception {
		Optional<Usuario> Usuario = Optional.empty();
		String qlString = "SELECT c FROM Usuario c WHERE c.idC = ?1";	// JPQL
		TypedQuery<Usuario> query = em.createQuery(qlString, Usuario.class);
		query.setParameter(1, id);
		List<Usuario> Usuarios = query.getResultList();
		
		if(Usuarios != null && !Usuarios.isEmpty())
			Usuario = Optional.of( Usuarios.get(0) );
		
		return Usuario;
	}
}
