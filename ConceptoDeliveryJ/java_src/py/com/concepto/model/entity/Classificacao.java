package py.com.concepto.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import br.com.db1.myBatisPersistence.annotations.MBClass;

@Entity
@Table(name = "bs_classificacao")
// @MBClass(additionalInsertColumns = "ID_FILIAL", additionalInsertValues =
// "#{@sessionHandler.ID_FILIAL}")
public class Classificacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3865042954414316196L;

	@Id
	@Column(name = "ID_CLASSIFICACAO", insertable = true, updatable = false, unique = true)
	private Long id;

	@Column(name = "TT_CLASSIFICACAO", length = 60, nullable = false)
	private String titulo;

	@Column(name = "DS_CLASSIFICACAO", length = 60, nullable = false)
	private String descricao;

	@Column(name = "BO_ATIVO", length = 60, nullable = false)
	private Boolean ativo;

	@JoinColumn(name = "ID_FILIAL", referencedColumnName = "ID_FILIAL", nullable = false)
	private Filial filial;

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

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Filial getFilial() {
		return filial;
	}
}