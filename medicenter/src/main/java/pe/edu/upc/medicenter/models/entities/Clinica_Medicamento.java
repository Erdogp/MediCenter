package pe.edu.upc.medicenter.models.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clinicas")
public class Clinica_Medicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCM;
	@Column(name = "nombreMedicamento", nullable = false, length = 40)
	private String nombreMedicamento;	
	@Column(name = "nombreClinica", nullable = false, length = 40)
	private String nombreClinica;
	@Column(name = "stock", nullable = false, length = 40)
	private int stock;
	
	
	public Clinica_Medicamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clinica_Medicamento(Integer idCM, String nombreMedicamento, String nombreClinica, int stock) {
		super();
		this.idCM = idCM;
		this.nombreMedicamento = nombreMedicamento;
		this.nombreClinica = nombreClinica;
		this.stock = stock;
	}
	public Integer getidCM() {
		return idCM;
	}
	public void setidCM(Integer idCM) {
		this.idCM = idCM;
	}
	public String getNombreMedicamento() {
		return nombreMedicamento;
	}
	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}
	public String getNombreClinica() {
		return nombreClinica;
	}
	public void NombreClinica(String nombreClinica) {
		this.nombreClinica = nombreClinica;
	}
	public int getStock() {
		return stock;
	}
	public void setDescripcion(int stock) {
		this.stock = stock;
	}
	
	
}
