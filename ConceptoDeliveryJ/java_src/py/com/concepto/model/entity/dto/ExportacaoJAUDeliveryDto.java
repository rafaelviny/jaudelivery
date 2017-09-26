package py.com.concepto.model.entity.dto;

import java.math.BigDecimal;
import java.text.Bidi;

public class ExportacaoJAUDeliveryDto {
	private Long codigoJauDelivery;
	private String nomeProduto;
	private BigDecimal preco01;
	private BigDecimal preco02;

	public Long getCodigoJauDelivery() {
		return codigoJauDelivery;
	}

	public void setCodigoJauDelivery(Long codigoJauDelivery) {
		this.codigoJauDelivery = codigoJauDelivery;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getPreco01() {
		return preco01;
	}

	public void setPreco01(BigDecimal preco01) {
		this.preco01 = preco01;
	}

	public BigDecimal getPreco02() {
		return preco02;
	}

	public void setPreco02(BigDecimal preco02) {
		this.preco02 = preco02;
	}

}
