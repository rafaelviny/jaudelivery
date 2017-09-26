package py.com.concepto.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6254839100620868907L;

	@Id
	@Column(name = "ID_EMPRESA", insertable = true, updatable = false, unique = true)
	private Long id;

	@Column(name = "CD_EMPRESA", insertable = true, updatable = false, unique = true)
	private Long codigo;

	@Column(name = "DS_EMPRESA", length = 60, nullable = false)
	private String descricao;

	@Column(name = "SUB_TITULO", length = 60, nullable = false)
	private String subtitulo;

	@Column(name = "BO_ATIVO", nullable = false)
	private Boolean ativo;

	@JoinColumn(name = "ID_CIDADE", referencedColumnName = "ID_CIDADE", nullable = false)
	private Cidade cidade;

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

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public Cidade getCidade() {
		return cidade;
	}

}
