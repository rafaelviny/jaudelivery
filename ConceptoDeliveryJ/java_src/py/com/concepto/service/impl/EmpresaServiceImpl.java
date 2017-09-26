package py.com.concepto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import py.com.concepto.dao.EmpresaDao;
import py.com.concepto.model.entity.Empresa;
import py.com.concepto.service.EmpresaService;
import br.com.db1.myBatisPersistence.service.GenericMyBatisServiceImpl;



@Service(value = "empresaService")
@Transactional(rollbackFor = Exception.class)
public class EmpresaServiceImpl extends GenericMyBatisServiceImpl<Empresa,Long> implements EmpresaService {


	@Autowired 
	private EmpresaDao empresaDao;

	public EmpresaDao getEmpresaDao() {
		return empresaDao;
	}

	public void setEmpresaDao(EmpresaDao empresaDao) {
		this.empresaDao = empresaDao;
		this.setGenericDao(empresaDao);
	}


}