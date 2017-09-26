package py.com.concepto.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "bs_opcional")
public class Opcional implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3865042954414316196L;

	@Id
	@Column(name = "ID_OPCIONAL", insertable = true, updatable = false, unique = true)
	private Long id;

	@Column(name = "TT_OPCIONAL", length = 60, nullable = false)
	private String titulo;

	@Column(name = "DS_OPCIONAL", length = 200, nullable = false)
	private String descricao;

	@JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO", nullable = false)
	private Produto produto;

	@Column(name = "VL_PRECO", nullable = false)
	private BigDecimal vlPreco;

	@Column(name = "BO_ATIVO", length = 200, nullable = false)
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

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setVlPreco(BigDecimal vlPreco) {
		this.vlPreco = vlPreco;
	}

	public BigDecimal getVlPreco() {
		return vlPreco;
	}

}