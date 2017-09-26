package py.com.concepto.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;


import py.com.concepto.dao.UsuarioDao;
import py.com.concepto.model.entity.Usuario;
import py.com.concepto.util.exception.ExceptionCode;
import br.com.db1.myBatisPersistence.dao.GenericMyBatisDaoImpl;
import br.com.db1.myBatisPersistence.util.MyBatisUtil;



@Repository("usuarioDao")
public class UsuarioDaoImpl extends GenericMyBatisDaoImpl<Usuario, Long> implements UsuarioDao {

	/**
	 * Construtor padrão da implementação do <code>Dao</code>.
	 */
	public UsuarioDaoImpl() {
		super(Usuario.class); 
	}
	
	/**
	 * pesquisa o usuario pelo login e senha usando na tela de autentificacao do sistema
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Usuario findUsuarioByAutentificacao(String login, String senha) {
		List<Usuario> list = this.getSqlSession().selectList("findUsuarioByAutentificacao", MyBatisUtil.createMap("login", login, "senha", senha ));	
		Usuario usuario = new Usuario();	
		if(list.size() == 0){
			// usuario não encontrado com o login e senha informado
			usuario.setCodigo(ExceptionCode.NOTFOUND404);
		}else{
			usuario = list.get(0);
		}
		return  usuario;			
	}
	
	@Override
	public String autenticaPermissaoCancelamentoProduto(String senha) {
		String usuarios = null;
		List<Usuario> list = this.getSqlSession().selectList("autenticaPermissaoCancelamentoProduto", MyBatisUtil.createMap("senha", senha ));	
		
		for (Usuario usuario : list) {
			if(usuarios == null){
				usuarios = "";
			}
			usuarios += usuario.getLogin() + ", ";
		}
		if(usuarios != null){
			return usuarios.substring(0, usuarios.length()-2);
		}
		return usuarios;
	}
	

}