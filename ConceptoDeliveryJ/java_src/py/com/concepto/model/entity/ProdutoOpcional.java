package py.com.concepto.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import br.com.db1.myBatisPersistence.annotations.MBSequenceGenerator;

@Entity
@Table(name = "ven_produto_opcional")
public class ProdutoOpcional implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3865042954414316196L;

	@Id
	@Column(name = "ID_PRODUTO_OPCIONAL", insertable = true, updatable = false, unique = true)
	@MBSequenceGenerator(sequenceName = "ven_produto_opcional")
	private Long id;

	@JoinColumn(name = "ID_DELIVERY_ITEM", referencedColumnName = "ID_DELIVERY_ITEM", nullable = false)
	private DeliveryItem deliveryItem;

	@JoinColumn(name = "ID_OPCIONAL", referencedColumnName = "ID_OPCIONAL", nullable = false)
	private Opcional opcional;

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

	public void setOpcional(Opcional opcional) {
		this.opcional = opcional;
	}

	public Opcional getOpcional() {
		return opcional;
	}

}