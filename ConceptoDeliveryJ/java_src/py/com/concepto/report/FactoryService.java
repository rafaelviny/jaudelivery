package py.com.concepto.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import py.com.concepto.service.DeliveryService;

@Component(value="FactoryService")
public class FactoryService {

	@Autowired
	public ReportService reportService;

	@Autowired
	public DeliveryService deliveryService;

	
}
