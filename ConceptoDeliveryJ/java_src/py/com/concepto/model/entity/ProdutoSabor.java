package py.com.concepto.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import br.com.db1.myBatisPersistence.annotations.MBSequenceGenerator;

@Entity
@Table(name = "ven_produto_sabor")
public class ProdutoSabor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3865042954414316196L;

	@Id
	@Column(name = "ID_PRODUTO_SABOR", insertable = true, updatable = false, unique = true)
	@MBSequenceGenerator(sequenceName = "ven_produto_sabor")
	private Long id;

	@JoinColumn(name = "ID_DELIVERY_ITEM", referencedColumnName = "ID_DELIVERY_ITEM", nullable = false)
	private DeliveryItem deliveryItem;

	@JoinColumn(name = "ID_SABOR", referencedColumnName = "ID_SABOR", nullable = false)
	private Sabor sabor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DeliveryItem getDeliveryItem() {
		return deliveryItem;
	}

	public void setDeliveryItem(DeliveryItem deliveryItem) {
		this.deliveryItem = deliveryItem;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

}