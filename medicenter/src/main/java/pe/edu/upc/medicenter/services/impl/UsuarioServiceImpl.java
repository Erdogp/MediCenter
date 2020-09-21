package pe.edu.upc.medicenter.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import pe.edu.upc.medicenter.models.entities.Usuario;
import pe.edu.upc.medicenter.repositories.UsuarioRepository;
import pe.edu.upc.medicenter.services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService,Serializable {
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuarioRepository usuarioRepository;

	@Transactional
	@Override
	public Usuario save(Usuario entity) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.save(entity);
	}

	@Transactional
	@Override
	public Usuario update(Usuario entity) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.update(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Override
	public List<Usuario> findAll() throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public List<Usuario> findByNombres(String nombres) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findByNombres(nombres);
	}

	@Override
	public Optional<Usuario> findByDNI(String dni) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findByDNI(dni);
	}

	@Override
	public Optional<Usuario> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}
}
