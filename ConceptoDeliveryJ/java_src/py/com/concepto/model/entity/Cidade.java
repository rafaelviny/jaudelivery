package py.com.concepto.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bs_cidade")
public class Cidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3865042954414316196L;

	@Id
	@Column(name = "ID_CIDADE", insertable = true, updatable = false, unique = true)
	private Long id;

	@Column(name = "DS_CIDADE", nullable = false)
	private String descricao;

	@Column(name = "BO_ATIVO", nullable = false)
	private Boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
