package pe.edu.upc.medicenter.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.upc.medicenter.models.entities.Clinica;
import pe.edu.upc.medicenter.models.entities.Distrito;
import pe.edu.upc.medicenter.services.ClinicaService;
import pe.edu.upc.medicenter.services.DistritoService;
import pe.edu.upc.medicenter.utils.Action;

@Named("clinicaView")		// Creando un Beans
@ViewScoped
public class ClinicaView implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private List<Clinica> clinicas;
	private Clinica clinica;
	private Clinica clinicaseleccionada;
	private Action action;

	
	@Inject
	private ClinicaService clinicaService;

	@PostConstruct
	public void init() {
		cleanForm();
		loadClinicas();
		action=Action.NONE;
	}
	
	public void loadClinicas() {
		try {
			this.clinicas = clinicaService.findAll();
		} catch( Exception e ) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}

	public void newClinica()
	{
		action=Action.NEW;
		cleanForm();
	}
	
	public void cleanForm()
	{
		this.clinica= new Clinica();
		this.clinicaseleccionada=null;
	}
	
	public void saveClinica() {
		try {
			if (action == Action.NEW) {
				clinicaService.save(this.clinica);
			} 
			else if (action == Action.EDIT) {
				clinicaService.update(this.clinica);
			}	
			action = Action.NONE;
			cleanForm();
			loadClinicas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	public void selectClinica(SelectEvent<Clinica> e) {
		this.clinicaseleccionada = e.getObject();
	}
	
	// Método que se ejecuta cuando hago click en el boton Editar
	public void editClinica() {
		if(clinicaseleccionada != null) {
			action = Action.EDIT;
			clinica = clinicaseleccionada;
			clinicaseleccionada = null;
		}
	}
	
	public void deleteClinica() {
		if(clinicaseleccionada != null) {
			try {
				clinicaService.deleteById(clinicaseleccionada.getIdC());
				action = Action.NONE;
				cleanForm();
				loadClinicas();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println( e.getMessage() );
			}
		}
	}
	
	public List<Clinica> getClinicas() {
		return clinicas;
	}


	public ClinicaService getClinicaService() {
		return clinicaService;
	}
	public Clinica getClinica() {
		return clinica;
	}
	
	
	
}
