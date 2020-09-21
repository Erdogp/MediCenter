package pe.edu.upc.medicenter.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cita")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCI;
	@Column(name = "nombrePaciente", nullable = false, length = 40)
	private String nombrePaciente;
	@Column(name = "nombreEspecialista", nullable = false, length = 40)
	private String nombreEspecialista;
	@Column(name = "descripcion", nullable = false, length = 40)
	private String descripcion;
	@Column(name = "horacita", nullable = false, length = 40)
	private String horacita;
	
	
	public Cita() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cita(Integer idCI, String nombrePaciente, String nombreEspecialista, String descripcion, String horacita) {
		super();
		this.idCI = idCI;
		this.nombrePaciente = nombrePaciente;
		this.nombreEspecialista = nombreEspecialista;
		this.descripcion = descripcion;
		this.horacita = horacita;
	}
	public Integer getIdCI() {
		return idCI;
	}
	public void setIdCI(Integer idCI) {
		this.idCI = idCI;
	}
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	public String getNombreEspecialista() {
		return nombreEspecialista;
	}
	public void nombreEspecialista(String nombreEspecialista) {
		this.nombreEspecialista = nombreEspecialista;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getHoraCita() {
		return horacita;
	}
	public void setHoraCita(String horacita) {
		this.horacita = horacita;
	}
	
	
}
