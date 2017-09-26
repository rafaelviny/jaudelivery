package py.com.concepto.dao;

import java.util.List;

import br.com.db1.myBatisPersistence.dao.GenericMyBatisDao;
import py.com.concepto.model.entity.Delivery;
import py.com.concepto.model.entity.dto.GraficoVendasDto;
import py.com.concepto.model.entity.dto.RelatorioDeliveryDto;

public interface DeliveryDao extends GenericMyBatisDao<Delivery, Long> {

	void deliveryConfirmado(Long delivery);

	List<Delivery> findDeliverysPendentesEntrega(Long idEmpresa);

	void deliveryRejeitado(Long delivery);

	void deliveryEnviado(Long delivery);

	List<GraficoVendasDto> findGraficoDeliveryDiario(Long idEmpresa);

	List<GraficoVendasDto> findGraficoDeliveryMensal(Long idEmpresa);

	List<Delivery> findDeliverysDoDia(Long idEmpresa);

	List<RelatorioDeliveryDto> findRelatorioDelivery(String where);

	List<Delivery> findAvaliacaoCliente(Long idEmpresa);

	List<GraficoVendasDto> findGraficoAvaliacaoDiario(Long idEmpresa);

	List<GraficoVendasDto> findGraficoAvaliacaoMensal(Long idEmpresa);

	List<Delivery> findUltimos5Deliverys(Long idCliente, Long idEmpresa);


}