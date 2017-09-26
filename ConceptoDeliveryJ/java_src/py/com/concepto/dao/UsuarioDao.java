package py.com.concepto.dao;

import br.com.db1.myBatisPersistence.dao.GenericMyBatisDao;
import py.com.concepto.model.entity.Usuario;



public interface UsuarioDao extends GenericMyBatisDao<Usuario, Long> {

	Usuario findUsuarioByAutentificacao(String login, String senha);

	String autenticaPermissaoCancelamentoProduto(String senha);

	
}