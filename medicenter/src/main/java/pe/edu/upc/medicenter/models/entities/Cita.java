package pe.edu.upc.medicenter.models.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "citas")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCita;

	@ManyToOne
	@JoinColumn(name="especialista_id")
	private Especialista especialista;
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
	@Column(name = "hora", nullable = false, length = 10)
	private String hora;
	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date fecha;
	
	@OneToOne(mappedBy="cita")
    private Historial_Clinico h_clinico;
	
	public Cita() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
