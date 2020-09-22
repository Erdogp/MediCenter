package pe.edu.upc.medicenter.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "especialidades")
public class Especialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id_Especialidad;
	
	@Column(name = "NombreEspecialidad", length = 20, nullable = false)
	private String NombreEspecialidad;
	 
	public void setId_Especialidad(Integer id_Especialidad) {
		Id_Especialidad = id_Especialidad;
	}
	 public Integer getId_Especialidad() {
		return Id_Especialidad;
	}
	 
	 public void setNombreEspecialidad(String nombreEspecialidad) {
		NombreEspecialidad = nombreEspecialidad;
	}
	 public String getNombreEspecialidad() {
		return NombreEspecialidad;
	}
}
