package py.com.concepto.model.entity.dto;

import java.math.BigDecimal;

public class RelatorioDeliveryDto {
	
	private String nomeFilial;
	private BigDecimal totalDelivery;
	private BigDecimal totalFlex;
	
	
	public String getNomeFilial() {
		return nomeFilial;
	}
	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}
	public BigDecimal getTotalDelivery() {
		return totalDelivery;
	}
	public void setTotalDelivery(BigDecimal totalDelivery) {
		this.totalDelivery = totalDelivery;
	}
	public BigDecimal getTotalFlex() {
		return totalFlex;
	}
	public void setTotalFlex(BigDecimal totalFlex) {
		this.totalFlex = totalFlex;
	}
	

}
