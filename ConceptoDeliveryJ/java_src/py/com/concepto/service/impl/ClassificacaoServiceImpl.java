package py.com.concepto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.db1.myBatisPersistence.service.GenericMyBatisServiceImpl;
import py.com.concepto.dao.ClassificacaoDao;
import py.com.concepto.model.entity.Classificacao;
import py.com.concepto.service.ClassificacaoService;

@Service(value = "classificacaoService")
@Transactional(rollbackFor = Exception.class)
public class ClassificacaoServiceImpl extends GenericMyBatisServiceImpl<Classificacao, Long>
		implements ClassificacaoService {

	@Autowired
	private ClassificacaoDao classificacaoDao;

	public void setClassificacaoDao(ClassificacaoDao classificacaoDao) {
		this.classificacaoDao = classificacaoDao;
		this.setGenericDao(classificacaoDao);
	}

}