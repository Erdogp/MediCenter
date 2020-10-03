package pe.edu.upc.medicenter.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.medicenter.models.entities.Historial_Clinico;
import pe.edu.upc.medicenter.services.Historial_ClinicoService;
	
@Named("HistorialClinicoView")
@ViewScoped
public class HistorialClinicoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Historial_Clinico> hisClinico;
	
	public List<Historial_Clinico> getHisClinico() {
		return hisClinico;
	}

	public Historial_ClinicoService getHisClinicoService() {
		return hisClinicoService;
	}

	@Inject
	private Historial_ClinicoService hisClinicoService;
	
	


}
