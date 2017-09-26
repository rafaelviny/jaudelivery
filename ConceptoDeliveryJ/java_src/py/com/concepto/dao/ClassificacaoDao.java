package py.com.concepto.dao;

import java.util.List;

import br.com.db1.myBatisPersistence.dao.GenericMyBatisDao;
import py.com.concepto.model.entity.Classificacao;

public interface ClassificacaoDao extends GenericMyBatisDao<Classificacao, Long> {

	List<Classificacao> findClassificacoesAtivos(Long idEmpresa);

}