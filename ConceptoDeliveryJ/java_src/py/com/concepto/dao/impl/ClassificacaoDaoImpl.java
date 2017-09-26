package py.com.concepto.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.db1.myBatisPersistence.dao.GenericMyBatisDaoImpl;
import br.com.db1.myBatisPersistence.util.MyBatisUtil;
import py.com.concepto.dao.ClassificacaoDao;
import py.com.concepto.model.entity.Classificacao;

@Repository("classificacaoDao")
public class ClassificacaoDaoImpl extends GenericMyBatisDaoImpl<Classificacao, Long> implements ClassificacaoDao {

	public ClassificacaoDaoImpl() {
		super(Classificacao.class);
	}

	@Override
	public List<Classificacao> findClassificacoesAtivos(Long idEmpresa) {
		return this.getSqlSession().selectList("findClassificacoesAtivos", MyBatisUtil.createMap("idEmpresa", idEmpresa));
	}



}