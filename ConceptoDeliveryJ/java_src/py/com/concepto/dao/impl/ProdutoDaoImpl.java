package py.com.concepto.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import py.com.concepto.dao.ProdutoDao;
import py.com.concepto.model.entity.Classificacao;
import py.com.concepto.model.entity.Produto;
import br.com.db1.exception.persistence.DB1PersistenceException;
import br.com.db1.myBatisPersistence.dao.GenericMyBatisDaoImpl;
import br.com.db1.myBatisPersistence.util.MyBatisUtil;

@Repository("produtoDao")
public class ProdutoDaoImpl extends GenericMyBatisDaoImpl<Produto, Long> implements ProdutoDao {

	public ProdutoDaoImpl() {
		super(Produto.class);
	}

	@Override
	public List<Produto> findProdustosAtivos() {
		return this.getSqlSession().selectList("findProdutosAtivos");
	}

	@Override
	public List<Produto> findProdutosByClassificacao(Long id) {
		return this.getSqlSession().selectList("findProdutosByClassificacao", MyBatisUtil.createMap("idClassificacao", id));
	}

	@Override
	public Produto findById(Long id, Long idFilial) {
		 return (Produto) this.getSqlSession().selectOne("findById", MyBatisUtil.createMap("id", id, "filial", idFilial));
	}


}