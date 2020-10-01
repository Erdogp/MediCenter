package pe.edu.upc.medicenter.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.upc.medicenter.models.entities.Clinica;
import pe.edu.upc.medicenter.models.entities.Medicamento;
import pe.edu.upc.medicenter.models.entities.MedicamentosXClinica;
import pe.edu.upc.medicenter.services.ClinicaService;
import pe.edu.upc.medicenter.services.MedXClinicaService;
import pe.edu.upc.medicenter.services.MedicamentosService;
import pe.edu.upc.medicenter.utils.Action;
@Named("medxclinicaView")		// Creando un Beans
@ViewScoped
public class MedXClinicaView implements Serializable {

	private static final long serialVersionUID = 1L;
	private Action action;
	private List<Clinica> clinicas;
	private List<Medicamento> medicamentos;
	private Medicamento mediseleccionado;
	private Clinica clinicaseleccionada;
	private MedicamentosXClinica medXClinica;
	private List<MedicamentosXClinica> listamedXclinica;
	private MedicamentosXClinica medxclinicaseleccionada;
	
	@Inject 
	private MedXClinicaService medxclinicaService;
	
	@Inject
	private MedicamentosService medicamenService;
	
	@Inject
	private ClinicaService clinicaService;
	
	@PostConstruct
	public void init() {
		cleanForm();
		loadMedicamentosYClinicas();
		action=Action.NONE;
	}
	public void loadMedicamentosYClinicas() {
		try {
			this.medicamentos=medicamenService.findAll();
			this.clinicas=clinicaService.findAll();
			loadMedicamentosXClinica(clinicas.get(0));
		} catch( Exception e ) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	
	public void loadMedicamentosXClinica(Clinica clinicaselected) {
		try {
			this.listamedXclinica=medxclinicaService.findByClinica(clinicaselected.getIdC());
		} catch( Exception e ) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	

	
	public void newMedicamento()
	{
		action=Action.NEW;
		cleanForm();
		loadMedicamentosYClinicas();
	}
	
	public void cleanForm()
	{
		this.medXClinica= new MedicamentosXClinica();
		this.medxclinicaseleccionada= null;
		this.clinicaseleccionada=null;
		this.mediseleccionado=null;
	}
	public void saveMedicamento() {
		try {
			if (action == Action.NEW ) {
				medXClinica.setClinica(clinicaseleccionada);
				medXClinica.setMedicamento(mediseleccionado);
				medxclinicaService.save(this.medXClinica);
						
			} 
			else if (action == Action.EDIT ) {
				medXClinica.setClinica(clinicaseleccionada);
				medXClinica.setMedicamento(mediseleccionado);
				medxclinicaService.update(this.medXClinica);

			}	
			loadMedicamentosXClinica(clinicaseleccionada);
			action = Action.NONE;
			cleanForm();
			loadMedicamentosYClinicas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	
	public void selectMedicamento(SelectEvent<Medicamento> e) {
		this.mediseleccionado = e.getObject();
	}
	public void selectClinica(SelectEvent<Clinica> e) {
		this.clinicaseleccionada = e.getObject();
	}
	
	public void selectMediXClinica(SelectEvent<MedicamentosXClinica> e)
	{
		this.medxclinicaseleccionada=e.getObject();
	}
	
	public void editMedicamento() {
		if(medxclinicaseleccionada != null) {
			action = Action.EDIT;
			medXClinica=medxclinicaseleccionada;
			medxclinicaseleccionada = null;
		}
	}
	
	public void deleteMedicamento() {
		if(medxclinicaseleccionada!= null) {
			try {
				medxclinicaService.deleteById(medxclinicaseleccionada.getIdMedClinica());
				action = Action.NONE;
				cleanForm();
				loadMedicamentosYClinicas();
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
	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}
	public MedicamentosXClinica getMedXClinica() {
		return medXClinica;
	}
	public List<MedicamentosXClinica> getListamedXclinica() {
		return listamedXclinica;
	}
	public MedXClinicaService getMedxclinicaService() {
		return medxclinicaService;
	}
	public MedicamentosService getMedicamenService() {
		return medicamenService;
	}
	public ClinicaService getClinicaService() {
		return clinicaService;
	}

	

	
}
