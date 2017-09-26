package py.com.concepto.dao;

import py.com.concepto.model.entity.Parametros;
import br.com.db1.myBatisPersistence.dao.GenericMyBatisDao;


public interface ParametrosDao extends GenericMyBatisDao<Parametros, Long> {
	
	/**
	 * retorna parametro
	 * @return Parametro
	 */
	public Parametros findParametro(String chave);

}