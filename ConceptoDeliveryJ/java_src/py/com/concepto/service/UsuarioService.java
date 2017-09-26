package py.com.concepto.service;

import py.com.concepto.model.entity.Usuario;
import br.com.db1.myBatisPersistence.service.GenericMyBatisService;



public interface UsuarioService extends GenericMyBatisService<Usuario, Long> {


	Usuario findUsuarioByAutentificacao(String login, String senha, String idioma);

	Usuario alteraSenha(String novaSenha, String senhaAntiga, Usuario usuarioLogado);
	
	void remoteItemSessao();

	String autenticaPermissaoCancelamentoProduto(String senha);


}

