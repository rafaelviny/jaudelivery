package py.com.concepto.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "sys_usuario_filial")
public class UsuarioFilial implements Serializable {

	private static final long serialVersionUID = -4946303065209121609L;

	@Id
	@Column(name = "ID_USUARIO_FILIAL",insertable = true, updatable = false, unique = true)
	private Long id;
	
	@JoinColumn(name = "ID_FILIAL", referencedColumnName = "ID_FILIAL")
	private Filial filial;
	
	@JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
