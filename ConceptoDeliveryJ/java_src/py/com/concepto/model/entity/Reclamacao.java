package py.com.concepto.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "bs_reclamacao")
public class Reclamacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3865042954414316196L;

	@Id
	@Column(name = "ID_RECLAMACAO", insertable = true, updatable = false, unique = true)
	private Long id;

	@Column(name = "OBSERVACAO", length = 60, nullable = false)
	private String observacao;

	@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", nullable = false)
	private Cliente cliente;

	@JoinColumn(name = "ID_FILIAL", referencedColumnName = "ID_FILIAL", nullable = false)
	private Filial filial;

	@Column(name = "DT_RECLAMACAO", length = 60, nullable = false)
	private Date dtReclamacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public void setDtReclamacao(Date dtReclamacao) {
		this.dtReclamacao = dtReclamacao;
	}

	public Date getDtReclamacao() {
		return dtReclamacao;
	}

}