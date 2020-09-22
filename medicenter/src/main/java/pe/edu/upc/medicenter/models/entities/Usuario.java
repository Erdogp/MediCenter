package pe.edu.upc.medicenter.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;
	
	@Column(name = "apellidos", length = 40, nullable = false)
	private String apellidos;
	
	@Column(name = "nombres", length = 40, nullable = false)
	private String nombres;
	
	@ManyToOne		// 2	
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;
	
	@Column(name = "celular", length = 9, nullable = false)
	private String celular;
	
	@Column(name = "direccion", length = 50, nullable = false)
	private String direccion;
	
	@Column(name = "dni", length = 8, nullable = false)
	private String dni;
	
	@Column(name = "fecha_nac", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date nacimiento;	
	
	@Column(name = "contrasena", length = 10, nullable = false)
	private String contrasena;
	
	@Column(name = "genero", length = 20, nullable = false)
	private String genero;

	/*@OneToOne
	@JoinColumn(name = "FK_historial_clinico")
	private Historial_Clinico h_clinico;*/
	
	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
}
