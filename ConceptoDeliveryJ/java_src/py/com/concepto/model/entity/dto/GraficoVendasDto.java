package py.com.concepto.model.entity.dto;

import java.math.BigDecimal;

public class GraficoVendasDto {
	private BigDecimal total;
	private String diaMes;

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getDiaMes() {
		return diaMes;
	}

	public void setDiaMes(String diaMes) {
		this.diaMes = diaMes;
	}

}
