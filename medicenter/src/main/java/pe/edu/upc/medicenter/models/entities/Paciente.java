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
import javax.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente
{	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_paciente;
	
	@OneToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
    @Column(name ="email", length = 30, nullable = false )
	private String email;
    
    @OneToMany(mappedBy="paciente")
    private List<Cita> citas;

	public Paciente() {
		citas= new ArrayList<>();
		}
    
    
}
