package py.com.concepto.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * Created by rafael on 12/12/2016.
 */
@Entity
@Table(name = "ven_troco")
public class Troco {
	@Id
	@Column(name = "ID_TROCO", insertable = true, updatable = false, unique = true)
	private Long id;

	@Column(name = "DS_MOEDA", length = 60, nullable = false)
	private String moeda;

	@Column(name = "VL_TROCO", length = 60, nullable = false)
	private BigDecimal valor;

	@JoinColumn(name = "ID_DELIVERY", referencedColumnName = "ID_DELIVERY")
	private Delivery delivery;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Delivery getDelivery() {
		return delivery;
	}
}
