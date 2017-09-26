package py.com.concepto.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.db1.myBatisPersistence.service.GenericMyBatisServiceImpl;
import py.com.concepto.dao.ClienteDao;
import py.com.concepto.dao.DeliveryDao;
import py.com.concepto.model.entity.Cliente;
import py.com.concepto.model.entity.Delivery;
import py.com.concepto.model.entity.Reclamacao;
import py.com.concepto.model.entity.dto.GraficoVendasDto;
import py.com.concepto.model.entity.dto.RelatorioDeliveryDto;
import py.com.concepto.service.DeliveryService;

@Service(value = "deliveryService")
@Transactional(rollbackFor = Exception.class)
public class DeliveryServiceImpl extends GenericMyBatisServiceImpl<Delivery, Long> implements DeliveryService {

	@Autowired
	private DeliveryDao deliveryDao;
	
	@Autowired
	private ClienteDao clienteDao;

	public void setDeliveryDao(DeliveryDao deliveryDao) {
		this.deliveryDao = deliveryDao;
		this.setGenericDao(deliveryDao);
	}

	@Override
	public List<Delivery> findDeliverysPendentesEntrega(Long idEmpresa) {
		List<Delivery> findDeliverysPendentes = deliveryDao.findDeliverysPendentesEntrega(idEmpresa);
		for (Delivery delivery : findDeliverysPendentes) {
			delivery.setCliente(clienteDao.findById(delivery.getCliente().getId()));
		}
		return findDeliverysPendentes;
	}
	
	@Override
	public List<Delivery> findDeliverysDoDia(Long idEmpresa) {
		List<Delivery> findDeliverysPendentes = deliveryDao.findDeliverysDoDia(idEmpresa);
		return findDeliverysPendentes;
	}

	@Override
	public List<Delivery> findAvaliacaoCliente(Long idEmpresa) {
		List<Delivery> findDeliverysPendentes = deliveryDao.findAvaliacaoCliente(idEmpresa);
		return findDeliverysPendentes;
	}
	
	@Override
	public void deliveryConfirmado(Long delivery){
		deliveryDao.deliveryConfirmado(delivery);
	}
	
	@Override
	public void deliveryRejeitado(Long delivery){
		deliveryDao.deliveryRejeitado(delivery);
	}

	@Override
	public void deliveryEnviado(Long delivery){
		deliveryDao.deliveryEnviado(delivery);
	}
	
	@Override
	public List<GraficoVendasDto> findGraficoDeliveryDiario(Long idEmpresa) {
		return deliveryDao.findGraficoDeliveryDiario(idEmpresa);
	}

	@Override
	public List<GraficoVendasDto> findGraficoAvaliacaoDiario(Long idEmpresa) {
		return deliveryDao.findGraficoAvaliacaoDiario(idEmpresa);
	}
	
	@Override
	public List<GraficoVendasDto> findGraficoDeliveryMensal(Long idEmpresa) {
		return deliveryDao.findGraficoDeliveryMensal(idEmpresa);
	}
	
	
	@Override
	public List<GraficoVendasDto> findGraficoAvaliacaoMensal(Long idEmpresa) {
		return deliveryDao.findGraficoAvaliacaoMensal(idEmpresa);
	}
	
	@Override
	public void realizarReclamacao(Reclamacao reclamacao){
		Cliente cliente = clienteDao.findById(reclamacao.getCliente().getId());
		reclamacao.setCliente(cliente);
		reclamacao.setDtReclamacao(new Date());
		cliente.getReclamacoes().add(reclamacao);
		clienteDao.update(cliente);


	}
	
	@Override
	public List<RelatorioDeliveryDto> findRelatorioDelivery(String where) {
		return deliveryDao.findRelatorioDelivery(where);}

}