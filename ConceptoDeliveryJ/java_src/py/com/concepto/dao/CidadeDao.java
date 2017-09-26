package py.com.concepto.dao;

import py.com.concepto.model.entity.Cidade;

import java.util.List;

import br.com.db1.myBatisPersistence.dao.GenericMyBatisDao;


public interface CidadeDao extends GenericMyBatisDao<Cidade, Long> {

	List<Cidade> findCidadesAtivas();
}