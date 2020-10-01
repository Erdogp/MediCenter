package pe.edu.upc.medicenter.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "distritos")
public class Distrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	//dfsdf
	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;
	
	@Column(name = "provincia", length = 30, nullable = false)
	private String provincia;
	
	@OneToMany(mappedBy = "distrito")		// 1(@OneToMany), 4(mappedBy)
	private List<Usuario> usuarios;
	
	@OneToMany(mappedBy="distrito")
	private List<Clinica> clinicas;

	public Distrito() {
		usuarios = new ArrayList<>();
		clinicas= new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Clinica> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}

	
}
