package pe.edu.upc.medicenter.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente extends Usuario
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 @Column(name = "cita", nullable = false )	
	private Date cita;
	 @ManyToOne// 1
	 @Column(name = "historialClinico", nullable = false )	
	 private historialClinico historialClinico;
	
	
}
