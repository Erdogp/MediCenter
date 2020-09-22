package pe.edu.upc.medicenter.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.upc.medicenter.models.entities.Usuario;
import pe.edu.upc.medicenter.services.UsuarioService;
import pe.edu.upc.medicenter.utils.Action;

@Named("usuarioView")		// Creando un Beans
@ViewScoped
public class UsuarioView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Usuario> usuarios;
	private Usuario usuario;
	private Usuario usuarioseleccionada;
	private Action action;
	
	@Inject
	private UsuarioService usuarioService;
	
	@PostConstruct
	public void init() {
		cleanForm();
		loadUsuarios();
		action=Action.NONE;
	}
	
	public void loadUsuarios() {
		try {
			this.usuarios = usuarioService.findAll();
		} catch( Exception e ) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}

	public void newUsuario()
	{
		action=Action.NEW;
		cleanForm();
	}
	
	public void cleanForm()
	{
		this.usuario= new Usuario();
		this.usuarioseleccionada=null;
	}
	
	public void saveUsuario() {
		try {
			if (action == Action.NEW) {
				usuarioService.save(this.usuario);
			} 
			else if (action == Action.EDIT) {
				usuarioService.update(this.usuario);
			}	
			action = Action.NONE;
			cleanForm();
			loadUsuarios();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	public void selectUsuario(SelectEvent<Usuario> e) {
		this.usuarioseleccionada = e.getObject();
	}
	
	// Método que se ejecuta cuando hago click en el boton Editar
	public void editUsuario() {
		if(usuarioseleccionada != null) {
			action = Action.EDIT;
			usuario = usuarioseleccionada;
			usuarioseleccionada = null;
		}
	}
	
	public void deleteUsuario() {
		if(usuarioseleccionada != null) {
			try {
				usuarioService.deleteById(usuarioseleccionada.getIdPersona());
				action = Action.NONE;
				cleanForm();
				loadUsuarios();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println( e.getMessage() );
			}
		}
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	public Usuario getUsuario() {
		return usuario;
	}
}
