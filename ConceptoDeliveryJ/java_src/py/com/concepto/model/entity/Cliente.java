package py.com.concepto.model.entity;

import java.io.Serializable;
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
@Table(name = "bs_cliente")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3865042954414316196L;

	@Id
	@Column(name = "ID_CLIENTE", insertable = true, updatable = false, unique = true)
	@MBSequenceGenerator(sequenceName = "bs_cliente")
	private Long id;

	@Column(name = "ID_FACEBOOK", insertable = true, updatable = false, unique = true)
	private String idFacebook;

	@Column(name = "ID_ONE_SIGNAL", length = 60, nullable = false)
	private String idOneSignal;
	
	@Column(name = "NM_CLIENTE", length = 60, nullable = false)
	private String nome;

	@Column(name = "NM_FACEBOOK_CLIENTE", length = 60, nullable = false)
	private String nomeFacebook;

	@Column(name = "TELEFONE", length = 60, nullable = false)
	private String telefone;

	@Column(name = "AVALIACAO", length = 60, nullable = false)
	private Long avaliacao;

	@Column(name = "BO_DESENVOLVEDOR", length = 60, nullable = false)
	private Boolean desenvolvedor;

	@JoinColumn(name = "ID_PROPRIETARIO", referencedColumnName = "ID_FILIAL")
	private Filial filial;

	@Column(name = "ENDERECO_1", length = 200, nullable = false)
	private String endereco1;

	@Column(name = "ENDERECO_2", length = 200, nullable = false)
	private String endereco2;

	@Column(name = "ENDERECO_3", length = 200, nullable = false)
	private String endereco3;

	@OneToMany
	@MBCascade(excludeStatement = "insertSimpleSemCascade", joinColumns = "ID_CLIENTE", targetJoinColumns = "ID_CLIENTE")
	private List<Reclamacao> reclamacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFacebook() {
		return nomeFacebook;
	}

	public void setNomeFacebook(String nomeFacebook) {
		this.nomeFacebook = nomeFacebook;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Long getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Long avaliacao) {
		this.avaliacao = avaliacao;
	}

	public void setIdFacebook(String idFacebook) {
		this.idFacebook = idFacebook;
	}

	public String getIdFacebook() {
		return idFacebook;
	}

	public void setEndereco1(String endereco1) {
		this.endereco1 = endereco1;
	}

	public String getEndereco1() {
		return endereco1;
	}

	public void setEndereco2(String endereco2) {
		this.endereco2 = endereco2;
	}

	public String getEndereco2() {
		return endereco2;
	}

	public void setEndereco3(String endereco3) {
		this.endereco3 = endereco3;
	}

	public String getEndereco3() {
		return endereco3;
	}

	public void setReclamacoes(List<Reclamacao> reclamacoes) {
		this.reclamacoes = reclamacoes;
	}

	public List<Reclamacao> getReclamacoes() {
		return reclamacoes;
	}

	public Boolean getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(Boolean desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Filial getFilial() {
		return filial;
	}

}