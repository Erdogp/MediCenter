package pe.edu.upc.medicenter.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.upc.medicenter.models.entities.Medicamento;
import pe.edu.upc.medicenter.services.MedicamentosService;
import pe.edu.upc.medicenter.utils.Action;

@Named("medicamentoView")		// Creando un Beans
@ViewScoped
public class MedicamentoView implements Serializable{

	private static final long serialVersionUID = 1L;
	private Medicamento medicamento;
	private List<Medicamento> medicamentos;	
	private Action action;
	private Medicamento mediseleccionado;
	
	@Inject
	private MedicamentosService medicamenService;
	
	@PostConstruct
	public void init() {
		cleanForm();
		loadMedicamentos();
		action=Action.NONE;
	}
	public void loadMedicamentos() {
		try {
			this.medicamentos = medicamenService.findAll();
			
		} catch( Exception e ) {
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	
	public void newMedicamento()
	{
		action=Action.NEW;
		cleanForm();
		loadMedicamentos();
	}
	
	public void cleanForm()
	{
		this.medicamento= new Medicamento();
		//this.clinicaseleccionada=null;
		this.mediseleccionado=null;
	}
	public void saveMedicamento() {
		try {
			if (action == Action.NEW ) {
				
				medicamenService.save(this.medicamento);
						
			} 
			else if (action == Action.EDIT) {
				medicamenService.update(this.medicamento);

			}	
			action = Action.NONE;
			cleanForm();
			loadMedicamentos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println( e.getMessage() );
		}
	}
	
	public void selectMedicamento(SelectEvent<Medicamento> e) {
		this.mediseleccionado = e.getObject();
	}
	public void editMedicamento() {
		if(mediseleccionado != null) {
			action = Action.EDIT;
			medicamento = mediseleccionado;
			mediseleccionado = null;
		}
	}
	
	public void deleteMedicamento() {
		if(mediseleccionado != null) {
			try {
				medicamenService.deleteById(mediseleccionado.getId());
				action = Action.NONE;
				cleanForm();
				loadMedicamentos();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println( e.getMessage() );
			}
		}
	}
	public Medicamento getMedicamento() {
		return medicamento;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public MedicamentosService getMedicamenService() {
		return medicamenService;
	}
	
	
	
	
}
