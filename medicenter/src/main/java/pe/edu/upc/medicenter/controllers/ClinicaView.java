package pe.edu.upc.medicenter.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.medicenter.models.entities.Clinica;
import pe.edu.upc.medicenter.services.ClinicaService;

@Named("clinicaView")		// Creando un Beans
@ViewScoped
public class ClinicaView implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private List<Clinica> clinicas;
	
	@Inject
	private ClinicaService clinicaService;
	
	@PostConstruct
	public void init() {
		loadClinicas();
	}
	
	public void loadClinicas() {
		try {
			this.clinicas = clinicaService.findAll();
		} catch( Exception e ) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}

	public List<Clinica> getClinicas() {
		return clinicas;
	}


	public ClinicaService getClinicaService() {
		return clinicaService;
	}

	
	
}
