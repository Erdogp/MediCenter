package pe.edu.upc.medicenter.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="medicamentosXclinicas")
public class MedicamentosXClinica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedClinica;
	
	@ManyToOne
	@JoinColumn(name="medicamento_ID")
	private Medicamento medicamento;
	@ManyToOne
	@JoinColumn(name="clinica_id")
	private Clinica clinica;
	
	@OneToMany(mappedBy="medicamentos")
	private List<Receta> recetas;

	public MedicamentosXClinica() {
		recetas = new ArrayList<>();
	}

	public Integer getIdMedClinica() {
		return idMedClinica;
	}

	public void setIdMedClinica(Integer idMedClinica) {
		this.idMedClinica = idMedClinica;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}
	
	
	
}
