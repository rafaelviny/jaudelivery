package py.com.concepto.service;

import java.util.List;

import br.com.db1.myBatisPersistence.service.GenericMyBatisService;
import py.com.concepto.model.entity.Delivery;
import py.com.concepto.model.entity.Reclamacao;
import py.com.concepto.model.entity.dto.GraficoVendasDto;
import py.com.concepto.model.entity.dto.RelatorioDeliveryDto;



public interface DeliveryService extends GenericMyBatisService<Delivery, Long> {
	
	void deliveryConfirmado(Long delivery);

	void deliveryRejeitado(Long delivery);

	void deliveryEnviado(Long delivery);

	List<Delivery> findDeliverysPendentesEntrega(Long idEmpresa);

	List<GraficoVendasDto> findGraficoDeliveryDiario(Long idEmpresa);

	List<GraficoVendasDto> findGraficoDeliveryMensal(Long idEmpresa);

	List<Delivery> findDeliverysDoDia(Long idEmpresa);

	void realizarReclamacao(Reclamacao reclamacao);

	List<Delivery> findAvaliacaoCliente(Long idEmpresa);

	List<GraficoVendasDto> findGraficoAvaliacaoDiario(Long idEmpresa);

	List<GraficoVendasDto> findGraficoAvaliacaoMensal(Long idEmpresa);
	
	List<RelatorioDeliveryDto> findRelatorioDelivery(String where);

}

