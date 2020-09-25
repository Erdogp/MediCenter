package pe.edu.upc.medicenter.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="recetas")
public class Receta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReceta;
	@ManyToOne
	@JoinColumn(name="h_clinico_ID")
	private Historial_Clinico h_clinico;
	
	@ManyToOne
	@JoinColumn(name="med_clinica_ID")
	private MedicamentosXClinica medicamentos;
	
}
