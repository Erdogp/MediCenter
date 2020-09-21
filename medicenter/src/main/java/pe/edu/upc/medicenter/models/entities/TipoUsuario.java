package pe.edu.upc.medicenter.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_usuarios")
public class TipoUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipo;
	
	@Column(name = "tipo",length = 15,nullable = false)
	private String tipo;
	
	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}
	public Integer getId_tipo() {
		return id_tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
	}

}
