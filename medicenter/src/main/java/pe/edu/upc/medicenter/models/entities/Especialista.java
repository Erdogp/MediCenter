package pe.edu.upc.medicenter.models.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "especialistas")
public class Especialista extends Usuario
{
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    @Column(name ="tiempo_experiencia", length = 2, nullable = false )
	private String tiempo_experiencia;// snake
    @Column(name ="lugar_atencion", length = 30, nullable = false )
	private String lugar_atencion;// snake
    @Column(name ="nacionalidad", length = 30, nullable = false )
	private String nacionalidad;
   @ManyToOne //1
   @JoinColumn(name = "especialidad_id")// snake
	private Especialidad especialidad;
	//private Date fechadecita;
	
	@OneToMany
	private List<Paciente> pacientes;
	
	
	
	
}
