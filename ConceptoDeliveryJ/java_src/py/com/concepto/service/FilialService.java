package py.com.concepto.service;

import java.util.List;

import py.com.concepto.model.entity.Filial;
import br.com.db1.myBatisPersistence.service.GenericMyBatisService;



public interface FilialService extends GenericMyBatisService<Filial, Long> {
	
	List<Filial> findListFilialByUsuarioId(Long idUsuario);
	
	void saveSubsidiaryInSession(Filial filial);

	void abreLocal(Long idFilial);

	void fechaLocal(Long idFilial);
	
	

}

