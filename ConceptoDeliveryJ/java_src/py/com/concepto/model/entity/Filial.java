package py.com.concepto.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.db1.myBatisPersistence.util.ISessionImplementation;

@Entity
@Table(name = "filial")
public class Filial implements Serializable, ISessionImplementation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3748301998522010701L;

	@Id
	@Column(name = "ID_FILIAL", insertable = true, updatable = false, unique = true)
	private Long id;

	@Column(name = "DS_FILIAL", length = 60, nullable = false)
	private String descricao;

	@Column(name = "HORARIO_ATENCAO", length = 60, nullable = false)
	private String horarioAtencao;

	@Column(name = "ENDERECO", length = 60, nullable = false)
	private String endereco;

	@Column(name = "BO_ATIVO", nullable = false)
	private Boolean ativo;

	@Column(name = "BO_ABERTO", nullable = false)
	private Boolean aberto;

	@JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID_EMPRESA")
	private Empresa empresa;

	@Column(name = "LOGO", nullable = false)
	private String logo;

	@Column(name = "LOGO_PRINCIPAL", nullable = false)
	private String logoPrincipal;

	@Transient
	private String lenguage;

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getLenguage() {
		return lenguage;
	}

	public void setLenguage(String lenguage) {
		this.lenguage = lenguage;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLogoPrincipal() {
		return logoPrincipal;
	}

	public void setLogoPrincipal(String logoPrincipal) {
		this.logoPrincipal = logoPrincipal;
	}

	public void setHorarioAtencao(String horarioAtencao) {
		this.horarioAtencao = horarioAtencao;
	}

	public String getHorarioAtencao() {
		return horarioAtencao;
	}

	public void setAberto(Boolean aberto) {
		this.aberto = aberto;
	}

	public Boolean getAberto() {
		return aberto;
	}
}
