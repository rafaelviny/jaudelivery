package py.com.concepto.service.impl;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.concepto.dao.UsuarioDao;
import py.com.concepto.model.entity.Filial;
import py.com.concepto.model.entity.Usuario;
import py.com.concepto.model.entity.UsuarioFilial;
import py.com.concepto.service.UsuarioService;
import py.com.concepto.util.exception.ConceptoException;
import br.com.db1.exception.persistence.DB1PersistenceException;
import br.com.db1.myBatisPersistence.service.GenericMyBatisServiceImpl;
import br.com.db1.myBatisPersistence.session.ConceptoSession;
import exception.ExceptionCode;
import flex.messaging.FlexContext;

@Service(value = "usuarioService")
@Transactional(rollbackFor = Exception.class)
public class UsuarioServiceImpl extends GenericMyBatisServiceImpl<Usuario,Long> implements UsuarioService {

	/**
	 * Propriedade que será injetada pelo <code>Spring</code>.
	 */
	@Autowired 
	private UsuarioDao usuarioDao;
	
	
	

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
		this.setGenericDao(usuarioDao);
	}




	@Override
	public Usuario findUsuarioByAutentificacao(String login, String senha, String idioma) {
		Usuario usuario = usuarioDao.findUsuarioByAutentificacao(login, senha);
		if(	usuario.getCodigo() != ExceptionCode.NOTFOUND404){
			ConceptoSession.getInstance().registerInSession("USUARIO_LOGADO",	usuario);
			
		}
		//***** seta locale padrao do sistema
		
		Locale locale = null;
		if("pt_BR".equals(idioma)){
		 locale = new Locale("pt", "BR", "");
		 Locale.setDefault(locale);
		}
		if("es_ES".equals(idioma)){
			locale = new Locale("es", "ES", "");
			Locale.setDefault(locale);
		}
		usuario.setSessionID(FlexContext.getFlexSession().getId());
		return usuario;
	}


	public Usuario alteraSenha(String novaSenha, String senhaAntiga, Usuario usuarioLogado){
		Usuario user = usuarioDao.findById(usuarioLogado.getId());
		if(senhaAntiga.compareTo(user.getSenha()) != 0){
			 throw new ConceptoException("La Contraseña Actual No Coincide con la Contraseña Almacenada");
		}
		user.setSenha(novaSenha);
		user.setPrimeiroAcesso(false);
		return usuarioDao.updateWithoutCascade(user);
	}
	
	
	@Override
	protected void beforeSave(Usuario newObject, Usuario oldObject) throws DB1PersistenceException {
		
		if(newObject.getId() == null){
			
			
			Filial filial = (Filial) ConceptoSession.getInstance().getAttribute("FILIAL_LOGADA");
			UsuarioFilial usuarioFilial = new UsuarioFilial();
			usuarioFilial.setFilial(filial);
			usuarioFilial.setUsuario(newObject);
			ArrayList<UsuarioFilial> usuarioFilialList = new ArrayList<UsuarioFilial>();
			usuarioFilialList.add(usuarioFilial);
			newObject.setUsuarioFilialList(usuarioFilialList);
			newObject.setSenha("123");
		}
		
		
		super.beforeSave(newObject, oldObject);
	}
	
	@Override
	public Usuario saveOrUpdate(Usuario newObject) throws DB1PersistenceException {
		return super.saveOrUpdate(newObject);
	}
	@Override
	public void remoteItemSessao() {
		ConceptoSession.getInstance().removeAttribute("SYSTEM_INSTANCE");
		ConceptoSession.getInstance().removeAttribute("FILIAL_LOGADA");
		ConceptoSession.getInstance().removeAttribute("USUARIO_LOGADO");
		ConceptoSession.getInstance().removeAttribute("ID_FILIAL");
	}
	
	
	
	@Override
	public String autenticaPermissaoCancelamentoProduto(String senha) {
		return usuarioDao.autenticaPermissaoCancelamentoProduto(senha);
	}
	

}