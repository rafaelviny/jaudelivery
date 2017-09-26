package py.com.concepto.model.entity;

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
@Table(name = "ven_delivery_item")
public class DeliveryItem {

	@Id
	@Column(name = "ID_DELIVERY_ITEM", insertable = true, updatable = false, unique = true)
	@MBSequenceGenerator(sequenceName = "ven_delivery_item")
	private Long id;

	@JoinColumn(name = "ID_DELIVERY", referencedColumnName = "ID_DELIVERY")
	private Delivery delivery;

	@JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO")
	private Produto produto;

	@Column(name = "QTD_PRODUTO", nullable = false)
	private BigDecimal quantidade;

	@Column(name = "VL_PRECO", nullable = false)
	private BigDecimal vlPreco;

	@Column(name = "VL_TOTAL", nullable = false)
	private BigDecimal vlTotal;

	@Column(name = "OBSERVACAO", nullable = false)
	private String observacao;

	@OneToMany
	@MBCascade(excludeStatement = "insertSimpleSemCascade", joinColumns = "ID_DELIVERY_ITEM", targetJoinColumns = "ID_DELIVERY_ITEM")
	private List<ProdutoSabor> produtoSabores;

	@OneToMany
	@MBCascade(excludeStatement = "insertSimpleSemCascade", joinColumns = "ID_DELIVERY_ITEM", targetJoinColumns = "ID_DELIVERY_ITEM")
	private List<ProdutoOpcional> produtoOpcionais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getVlPreco() {
		return vlPreco;
	}

	public void setVlPreco(BigDecimal vlPreco) {
		this.vlPreco = vlPreco;
	}

	public void setProdutoSabores(List<ProdutoSabor> produtoSabores) {
		this.produtoSabores = produtoSabores;
	}

	public List<ProdutoSabor> getProdutoSabores() {
		return produtoSabores;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public void setProdutoOpcionais(List<ProdutoOpcional> produtoOpcionais) {
		this.produtoOpcionais = produtoOpcionais;
	}

	public List<ProdutoOpcional> getProdutoOpcionais() {
		return produtoOpcionais;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public void setVlTotal(BigDecimal vlTotal) {
		this.vlTotal = vlTotal;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public BigDecimal getVlTotal() {
		return vlTotal;
	}
}
