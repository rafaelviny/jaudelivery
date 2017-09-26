package py.com.concepto.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "sys_parametros")
public class Parametros {


	@Column(name = "BS_PARAMETROS", length = 60, nullable = false)
	private String parametro;
	
	@Column(name = "VALOR", length = 60, nullable = false)
	private String valor;




	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
	

}
