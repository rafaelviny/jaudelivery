package py.com.concepto.dao;

import java.util.List;

import br.com.db1.myBatisPersistence.dao.GenericMyBatisDao;
import py.com.concepto.model.entity.Produto;

public interface ProdutoDao extends GenericMyBatisDao<Produto, Long> {

	List<Produto> findProdustosAtivos();

	List<Produto> findProdutosByClassificacao(Long id);

	Produto findById(Long codigoJauDelivery, Long idFilial);

}