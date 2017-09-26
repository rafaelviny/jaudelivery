package py.com.concepto.dao;

import java.util.List;

import br.com.db1.myBatisPersistence.dao.GenericMyBatisDao;
import py.com.concepto.model.entity.Filial;


public interface FilialDao extends GenericMyBatisDao<Filial, Long> {

	List<Filial> findListFilialByUsuarioId(Long idUsuario);

	List<Filial> findFiliaisByCidade(Long idCidade);

	void abreLocal(Long idFilial);

	void fechaLocal(Long idFilial);
	
	

}