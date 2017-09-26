package py.com.concepto.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import py.com.concepto.dao.EmpresaDao;
import py.com.concepto.model.entity.Cidade;
import py.com.concepto.model.entity.Empresa;
import br.com.db1.myBatisPersistence.dao.GenericMyBatisDaoImpl;
import br.com.db1.myBatisPersistence.util.MyBatisUtil;



@Repository("empresaDao")
public class EmpresaDaoImpl extends GenericMyBatisDaoImpl<Empresa, Long> implements EmpresaDao {

	public EmpresaDaoImpl() {
		super(Empresa.class); 
	}

}