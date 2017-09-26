package py.com.concepto.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.db1.myBatisPersistence.dao.GenericMyBatisDaoImpl;
import br.com.db1.myBatisPersistence.util.MyBatisUtil;
import py.com.concepto.dao.DeliveryDao;
import py.com.concepto.model.entity.Delivery;
import py.com.concepto.model.entity.dto.GraficoVendasDto;
import py.com.concepto.model.entity.dto.RelatorioDeliveryDto;

@Repository("deliveryDao")
public class DeliveryDaoImpl extends GenericMyBatisDaoImpl<Delivery, Long> implements DeliveryDao {

	public DeliveryDaoImpl() {
		super(Delivery.class);
	}


	public List<Delivery> findDeliverysPendentesEntrega(Long idEmpresa) {
		return this.getSqlSession().selectList("findDeliverysPendentesEntrega", MyBatisUtil.createMap("idEmpresa", idEmpresa));
	}


	@Override
	public void deliveryConfirmado(Long delivery) {
		this.getSqlSession().update("deliveryConfirmado", MyBatisUtil.createMap("id", delivery));
		
	}


	@Override
	public void deliveryRejeitado(Long delivery) {
		this.getSqlSession().update("deliveryRejeitado", MyBatisUtil.createMap("id", delivery));
	}
	
	@Override
	public void deliveryEnviado(Long delivery) {
		this.getSqlSession().update("deliveryEnviado", MyBatisUtil.createMap("id", delivery));
	}


	@Override
	public List<Delivery> findUltimos5Deliverys(Long idCliente, Long idEmpresa) {
		return this.getSqlSession().selectList("findUltimos5Deliverys", MyBatisUtil.createMap("idCliente", idCliente, "idEmpresa", idEmpresa));
	}

	
	@Override
	public List<GraficoVendasDto> findGraficoDeliveryDiario(Long idEmpresa) {
		return this.getSqlSession().selectList("findGraficoDeliveryDiario", MyBatisUtil.createMap("idEmpresa", idEmpresa));
	}
	
	@Override
	public List<GraficoVendasDto> findGraficoAvaliacaoDiario(Long idEmpresa) {
		return this.getSqlSession().selectList("findGraficoAvaliacaoDiario", MyBatisUtil.createMap("idEmpresa", idEmpresa));
	}
	
	
	@Override
	public List<GraficoVendasDto> findGraficoDeliveryMensal(Long idEmpresa) {
		return this.getSqlSession().selectList("findGraficoDeliveryMensal", MyBatisUtil.createMap("idEmpresa", idEmpresa));
	}
	
	@Override
	public List<GraficoVendasDto> findGraficoAvaliacaoMensal(Long idEmpresa) {
		return this.getSqlSession().selectList("findGraficoAvaliacaoMensal", MyBatisUtil.createMap("idEmpresa", idEmpresa));
	}


	@Override
	public List<Delivery> findDeliverysDoDia(Long idEmpresa) {
		return this.getSqlSession().selectList("findDeliverysDoDia", MyBatisUtil.createMap("idEmpresa", idEmpresa));
	}


	@Override
	public List<Delivery> findAvaliacaoCliente(Long idEmpresa) {
		 return this.getSqlSession().selectList("findAvaliacaoCliente", MyBatisUtil.createMap("idEmpresa", idEmpresa));
		 
	}
	@Override
	public List<RelatorioDeliveryDto> findRelatorioDelivery(String where) {
		return this.getSqlSession().selectList("findRelatorioDelivery", MyBatisUtil.createMap("condition", where));
	}
	
	


}