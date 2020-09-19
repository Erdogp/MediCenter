package pe.edu.upc.medicenter.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clinicas")
public class Clinica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idC;
	@Column(name = "nombrec", nullable = false, length = 40)
	private String nombrec;
	@Column(name = "ubcacion", nullable = false, length = 40)
	private String ubicacion;
	@Column(name = "descripcion", nullable = false, length = 40)
	private String descripcion;
	@Column(name = "horario", nullable = false, length = 40)
	private String horario;
	public Clinica() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clinica(Integer idC, String nombrec, String ubicacion, String descripcion, String horario) {
		super();
		this.idC = idC;
		this.nombrec = nombrec;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.horario = horario;
	}
	public Integer getIdC() {
		return idC;
	}
	public void setIdC(Integer idC) {
		this.idC = idC;
	}
	public String getNombrec() {
		return nombrec;
	}
	public void setNombrec(String nombrec) {
		this.nombrec = nombrec;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
}
