package py.com.concepto.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import py.com.concepto.dao.CidadeDao;
import py.com.concepto.model.entity.Cidade;
import br.com.db1.myBatisPersistence.dao.GenericMyBatisDaoImpl;



@Repository("cidadeDao")
public class CidadeDaoImpl extends GenericMyBatisDaoImpl<Cidade, Long> implements CidadeDao {

	public CidadeDaoImpl() {
		super(Cidade.class); 
	}
	
	
	@Override
	public List<Cidade> findCidadesAtivas(){
		return this.getSqlSession().selectList("findCidadesAtivas");
	}


}