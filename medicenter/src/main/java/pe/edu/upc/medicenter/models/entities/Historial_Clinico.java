package pe.edu.upc.medicenter.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import javax.persistence.ManyToOne;
 
import javax.persistence.Table;

@Entity
@Table(name = "Hitorial_Clinico")
public class Historial_Clinico {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_historial_clinico;
	
	@Column( name = "direccion_clinica", length = 40  , nullable = false)
    private String direc_clinica;
	@Column (name = "tipo_enfermedad" , length = 40 , nullable = true)
    private String tipo_enfermedad;
	@Column (name = "diagnostico", length = 40 , nullable = true )
    private String diagnostico;
	@Column(name = "alergia" , length = 30 , nullable = true )
    private String alergia;
	@Column ( name = "evolucion" , length = 50 , nullable = true)
	private String evolucion;
	
	/*@OneToOne(mappedBy="h_clinico")
    private Usuario usuario;*/
	
	public Integer getId_historial_clinico() {
		return id_historial_clinico;
	}
	public void setId_historial_clinico(Integer id_historial_clinico) {
		this.id_historial_clinico = id_historial_clinico;
	}
	public String getDirec_clinica() {
		return direc_clinica;
	}
	public void setDirec_clinica(String direc_clinica) {
		this.direc_clinica = direc_clinica;
	}
	public String getTipo_enfermedad() {
		return tipo_enfermedad;
	}
	public void setTipo_enfermedad(String tipo_enfermedad) {
		this.tipo_enfermedad = tipo_enfermedad;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getAlergia() {
		return alergia;
	}
	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}
	public String getEvolucion() {
		return evolucion;
	}
	public void setEvolucion(String evolucion) {
		this.evolucion = evolucion;
	}


}
