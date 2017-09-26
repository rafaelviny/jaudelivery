package py.com.concepto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.db1.exception.persistence.DB1PersistenceException;
import br.com.db1.myBatisPersistence.service.GenericMyBatisServiceImpl;
import br.com.db1.myBatisPersistence.session.ConceptoSession;
import py.com.concepto.dao.FilialDao;
import py.com.concepto.model.entity.Filial;
import py.com.concepto.service.FilialService;

@Service(value = "filialService")
@Transactional(rollbackFor = Exception.class)
public class FilialServiceImpl extends GenericMyBatisServiceImpl<Filial, Long>
		implements FilialService {

	@Autowired
	private FilialDao filialDao;
	


	public FilialDao getFilialDao() {
		return filialDao;
	}

	public void setFilialDao(FilialDao filialDao) {
		this.filialDao = filialDao;
		this.setGenericDao(filialDao);
	}

	@Override
	public List<Filial> findListFilialByUsuarioId(Long idUsuario) {
		return filialDao.findListFilialByUsuarioId(idUsuario);
	}

	/**
	 * salva a filial na sessao
	 */
	public void saveSubsidiaryInSession(Filial filial) {
		ConceptoSession.getInstance();
		//		DB1Session.createJavaSession();
		ConceptoSession.getInstance().registerInSession("FILIAL_LOGADA",	filial);
		
		ConceptoSession.getInstance().registerInSession("ID_FILIAL",	filial.getId());
		
	}
	/**
	 * metodo executado antes de salvar uma filial
	 */
	@Override
	protected void beforeSave(Filial newObject, Filial oldObject)
			throws DB1PersistenceException {

		super.beforeSave(newObject, oldObject);
	}

	
	@Override
	public void abreLocal(Long idFilial){
		filialDao.abreLocal(idFilial);
	}
	
	@Override
	public void fechaLocal(Long idFilial){
		filialDao.fechaLocal(idFilial);
	}
		
	}