package py.com.concepto.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import py.com.concepto.dao.FilialDao;
import py.com.concepto.model.entity.Filial;
import br.com.db1.myBatisPersistence.dao.GenericMyBatisDaoImpl;
import br.com.db1.myBatisPersistence.util.MyBatisUtil;

@Repository("filialDao")
public class FilialDaoImpl extends GenericMyBatisDaoImpl<Filial, Long> implements FilialDao {

	/**
	 * Construtor padrão da implementação do <code>Dao</code>.
	 */
	public FilialDaoImpl() {
		super(Filial.class); 
	}

	
	/**
	 * pesquisa todas as filiais vinculadas a um usuario
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Filial> findListFilialByUsuarioId(Long idUsuario) {

		return  this.getSqlSession().selectList("findListFilialByUsuarioId", MyBatisUtil.createMap("idUsuario", idUsuario));			
	}
	
	@Override
	public List<Filial> findFiliaisByCidade(Long idCidade){
		System.out.println(new Date());
		System.out.println(new Date());
		System.out.println(new Date());
		System.out.println(new Date());
		return this.getSqlSession().selectList("findFiliaisByCidade", MyBatisUtil.createMap("idCidade", idCidade));
	}


	@Override
	public void abreLocal(Long idFilial) {
		this.getSqlSession().update("abreLocal", MyBatisUtil.createMap("id", idFilial));
	}
	@Override
	public void fechaLocal(Long idFilial) {
		this.getSqlSession().update("fechaLocal", MyBatisUtil.createMap("id", idFilial));
	}

	
}