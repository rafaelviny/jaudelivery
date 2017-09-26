package py.com.concepto.dao;

import py.com.concepto.model.entity.Cidade;
import py.com.concepto.model.entity.Empresa;

import java.util.List;

import br.com.db1.myBatisPersistence.dao.GenericMyBatisDao;


public interface EmpresaDao extends GenericMyBatisDao<Empresa, Long> {

}