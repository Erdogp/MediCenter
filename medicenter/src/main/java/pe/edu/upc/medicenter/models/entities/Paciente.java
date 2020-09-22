package pe.edu.upc.medicenter.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pacientes")
public class Paciente
{	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "cita", nullable = false )	
	@Temporal(TemporalType.TIME)
	private Date cita;
	/* @ManyToOne// 1
	 @Column(name = "historialClinico", nullable = false )	
	 private Historial_Clinico historialClinico;
	//private Integer lol;*/
	
}
