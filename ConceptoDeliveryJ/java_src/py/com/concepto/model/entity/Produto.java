package py.com.concepto.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.db1.myBatisPersistence.annotations.MBCascade;
import br.com.db1.myBatisPersistence.annotations.MBSequenceGenerator;

@Entity
@Table(name = "bs_produto")
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3865042954414316196L;

	@Id
	@Column(name = "ID_PRODUTO", insertable = true, updatable = false, unique = true)
	@MBSequenceGenerator(sequenceName = "bs_produto")
	private Long id;

	@Column(name = "TT_PRODUTO", length = 60, nullable = false)
	private String titulo;

	@Column(name = "DS_PRODUTO", length = 200, nullable = false)
	private String descricao;

	@Column(name = "VL_PRECO", nullable = false)
	private BigDecimal vlPreco;

	@Column(name = "QTD_MAX_SABOR", nullable = false)
	private Long qtdMaximaSabor;

	@Column(name = "BO_ATIVO", nullable = false)
	private Boolean ativo;

	@Column(name = "BO_MAIOR_PRECO", nullable = false)
	private Boolean maiorPreco;
	
	@Column(name = "BO_PROD_DIVIDIDO_NR_SABOR_ROUNDUP", nullable = false)
	private Boolean produtoDivididoNrSaborRoundUP;

	@JoinColumn(name = "ID_CLASSIFICACAO", referencedColumnName = "ID_CLASSIFICACAO", nullable = false)
	private Classificacao classificacao;

	@JoinColumn(name = "ID_FILIAL", referencedColumnName = "ID_FILIAL", nullable = false)
	private Filial filial;

	@OneToMany
	@MBCascade(excludeStatement = "insertSimpleSemCascade", joinColumns = "ID_PRODUTO", targetJoinColumns = "ID_PRODUTO")
	private List<Sabor> sabores;

	@OneToMany
	@MBCascade(excludeStatement = "insertSimpleSemCascade", joinColumns = "ID_PRODUTO", targetJoinColumns = "ID_PRODUTO")
	private List<Opcional> opcionais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public Boolean getMaiorPreco() {
		return maiorPreco;
	}

	public void setMaiorPreco(Boolean maiorPreco) {
		this.maiorPreco = maiorPreco;
	}

	public BigDecimal getVlPreco() {
		return vlPreco;
	}

	public void setVlPreco(BigDecimal vlPreco) {
		this.vlPreco = vlPreco;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	public void setQtdMaximaSabor(Long qtdMaximaSabor) {
		this.qtdMaximaSabor = qtdMaximaSabor;
	}

	public Long getQtdMaximaSabor() {
		return qtdMaximaSabor;
	}

	public void setSabores(List<Sabor> sabores) {
		this.sabores = sabores;
	}

	public List<Sabor> getSabores() {
		return sabores;
	}

	public void setOpcionais(List<Opcional> opcionais) {
		this.opcionais = opcionais;
	}

	public List<Opcional> getOpcionais() {
		return opcionais;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Filial getFilial() {
		return filial;
	}
	public void setProdutoDivididoNrSaborRoundUP(Boolean produtoDivididoNrSaborRoundUP) {
		this.produtoDivididoNrSaborRoundUP = produtoDivididoNrSaborRoundUP;
	}
	public Boolean getProdutoDivididoNrSaborRoundUP() {
		return produtoDivididoNrSaborRoundUP;
	}
}