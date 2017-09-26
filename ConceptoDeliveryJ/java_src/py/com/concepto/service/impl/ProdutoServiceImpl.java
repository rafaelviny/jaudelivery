package py.com.concepto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.db1.exception.persistence.DB1PersistenceException;
import br.com.db1.myBatisPersistence.service.GenericMyBatisServiceImpl;
import py.com.concepto.dao.ProdutoDao;
import py.com.concepto.model.entity.Produto;
import py.com.concepto.service.ProdutoService;

@Service(value = "produtoService")
@Transactional(rollbackFor = Exception.class)
public class ProdutoServiceImpl extends GenericMyBatisServiceImpl<Produto, Long> implements ProdutoService {

	@Autowired
	private ProdutoDao produtoDao;

	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
		this.setGenericDao(produtoDao);
	}
	
	@Override
	protected void beforeSave(Produto newObject, Produto oldObject) throws DB1PersistenceException {
		// TODO Auto-generated method stub
		super.beforeSave(newObject, oldObject);
	}

}