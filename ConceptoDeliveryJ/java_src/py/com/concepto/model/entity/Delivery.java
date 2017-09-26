package py.com.concepto.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.JsonAdapter;

import br.com.db1.myBatisPersistence.annotations.MBCascade;
import br.com.db1.myBatisPersistence.annotations.MBSequenceGenerator;
import py.com.concepto.webservice.util.DateTypeAdapter;

@Entity
@Table(name = "ven_delivery")
public class Delivery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3865042954414316196L;

	@Id
	@Column(name = "ID_DELIVERY", insertable = true, updatable = false, unique = true)
	@MBSequenceGenerator(sequenceName = "ven_delivery")
	private Long id;

	@Column(name = "TOKEN", nullable = false)
	private String token;

	@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", nullable = false)
	private Cliente cliente;

	@JoinColumn(name = "ID_FILIAL", referencedColumnName = "ID_FILIAL", nullable = false)
	private Filial filial;

	@Column(name = "ENDERECO_CLIENTE", length = 60, nullable = false)
	private String endereco;

	@Column(name = "DT_DELIVERY", length = 60, nullable = false)
	@JsonAdapter(DateTypeAdapter.class)
	private Date dtDelivery;

	@Column(name = "LONGITUDE", length = 60, nullable = false)
	private BigDecimal longitude;

	@Column(name = "LATITUDE", length = 60, nullable = false)
	private BigDecimal latitude;

	@Column(name = "VL_TOTAL", length = 60, nullable = false)
	private BigDecimal vlTotal;

	@Column(name = "BO_CONFIRMADO")
	private Boolean confirmado;

	@Column(name = "BO_REJEITADO")
	private Boolean rejeitado;

	@Column(name = "BO_ENVIADO")
	private Boolean enviado;

	@Column(name = "AVALIACAO_CLIENTE")
	private BigDecimal avaliacao;

	@Column(name = "COMENTARIO_CLIENTE")
	private String comentarioCliente;

	@OneToMany
	@MBCascade(excludeStatement = "insertSimpleSemCascade", joinColumns = "ID_DELIVERY", targetJoinColumns = "ID_DELIVERY")
	private List<DeliveryItem> itens;

	@OneToMany
	@MBCascade(excludeStatement = "insertSimpleSemCascade", joinColumns = "ID_DELIVERY", targetJoinColumns = "ID_DELIVERY")
	private List<Troco> trocos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<DeliveryItem> getItens() {
		return itens;
	}

	public void setItens(List<DeliveryItem> itens) {
		this.itens = itens;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public void setVlTotal(BigDecimal vlTotal) {
		this.vlTotal = vlTotal;
	}

	public BigDecimal getVlTotal() {
		return vlTotal;
	}

	public void setTrocos(List<Troco> trocos) {
		this.trocos = trocos;
	}

	public List<Troco> getTrocos() {
		return trocos;
	}

	public void setDtDelivery(Date dtDelivery) {
		this.dtDelivery = dtDelivery;
	}

	public Date getDtDelivery() {
		return dtDelivery;
	}

	public void setEnviado(Boolean enviado) {
		this.enviado = enviado;
	}

	public Boolean getEnviado() {
		return enviado;
	}

	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}

	public Boolean getConfirmado() {
		return confirmado;
	}

	public void setRejeitado(Boolean rejeitado) {
		this.rejeitado = rejeitado;
	}

	public Boolean getRejeitado() {
		return rejeitado;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Filial getFilial() {
		return filial;
	}

	public BigDecimal getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(BigDecimal avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getComentarioCliente() {
		return comentarioCliente;
	}

	public void setComentarioCliente(String comentarioCliente) {
		this.comentarioCliente = comentarioCliente;
	}

}