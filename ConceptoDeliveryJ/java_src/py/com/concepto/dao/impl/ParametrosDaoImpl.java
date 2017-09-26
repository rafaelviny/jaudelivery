package py.com.concepto.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import py.com.concepto.dao.ParametrosDao;
import py.com.concepto.model.entity.Parametros;
import br.com.db1.myBatisPersistence.dao.GenericMyBatisDaoImpl;
import exception.ConceptoException;



@Repository("parametrosDao")
public class ParametrosDaoImpl extends GenericMyBatisDaoImpl<Parametros, Long> implements ParametrosDao {

	public ParametrosDaoImpl() {
		super(Parametros.class); 
	}

	public Parametros findParametro(String chave){
		List<Parametros> parametros = findByCondition("parametro = '" + chave + "'");
		if(parametros != null && parametros.size()>0){
			return parametros.get(0);
		}else{
			throw new ConceptoException("Parametro " + chave + " não configurado");
		}
	}
	

	


}