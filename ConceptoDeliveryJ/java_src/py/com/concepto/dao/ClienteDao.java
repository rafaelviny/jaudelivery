package py.com.concepto.dao;

import br.com.db1.myBatisPersistence.dao.GenericMyBatisDao;
import py.com.concepto.model.entity.Cliente;

public interface ClienteDao extends GenericMyBatisDao<Cliente, Long> {

	Cliente findClienteByFacebookID(String idFacebook);


}