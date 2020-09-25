package pe.edu.upc.medicenter.models.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "especialistas")
public class Especialista
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_especialista;
	@OneToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
    @Column(name ="tiempo_experiencia", length = 2, nullable = false )
	private String tiempo_experiencia;// snake
    @Column(name ="email", length = 30, nullable = false )
	private String email;// snake
   
    @ManyToOne
    @JoinColumn(name="clinica_id")
	private Clinica clinica;
    @ManyToOne
    @JoinColumn(name="especialidad_id")
	private Especialidad especialidad;
    
    @OneToMany(mappedBy="especialista")
    private List<Cita> citas;
    
	public Especialista() {
		citas= new ArrayList<>();
	}

	
}
