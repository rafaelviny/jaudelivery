package py.com.concepto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.db1.myBatisPersistence.service.GenericMyBatisServiceImpl;
import py.com.concepto.dao.ClienteDao;
import py.com.concepto.model.entity.Cliente;
import py.com.concepto.service.ClienteService;

@Service(value = "clienteService")
@Transactional(rollbackFor = Exception.class)
public class ClienteServiceImpl extends GenericMyBatisServiceImpl<Cliente, Long> implements ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
		this.setGenericDao(clienteDao);
	}

}