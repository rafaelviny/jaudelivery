package py.com.concepto.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.db1.myBatisPersistence.dao.GenericMyBatisDaoImpl;
import br.com.db1.myBatisPersistence.util.MyBatisUtil;
import py.com.concepto.dao.ClienteDao;
import py.com.concepto.model.entity.Cliente;

@Repository("clienteDao")
public class ClienteDaoImpl extends GenericMyBatisDaoImpl<Cliente, Long> implements ClienteDao {

	public ClienteDaoImpl() {
		super(Cliente.class);
	}


	@Override
	public Cliente findClienteByFacebookID(String idFacebook) {
		return (Cliente) this.getSqlSession().selectOne("findClienteByFacebookID", MyBatisUtil.createMap("idFacebook", idFacebook));
	}

}