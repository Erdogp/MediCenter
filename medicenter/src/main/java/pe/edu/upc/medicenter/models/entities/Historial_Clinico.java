package pe.edu.upc.medicenter.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//import javax.persistence.ManyToOne;
 
import javax.persistence.Table;

@Entity
@Table(name = "historial_clinicos")
public class Historial_Clinico {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_historial;
	
	@OneToOne
	@JoinColumn(name="cita_id")
	private Cita cita;
	
	@Column( name = "descripcion_dolores", length = 40  , nullable = false)
    private String descripcion_dolores;
	@Column (name = "alergias" , length = 40 , nullable = true)
    private String alergias;
	@Column (name = "diagnostico", length = 40 , nullable = true )
    private String diagnostico;

	@OneToMany(mappedBy="h_clinico")
	private List<Receta> recetas;

	public Historial_Clinico() {
	recetas= new ArrayList<>();	
	}
	

}
