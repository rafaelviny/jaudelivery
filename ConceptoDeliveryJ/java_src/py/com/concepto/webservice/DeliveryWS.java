package py.com.concepto.webservice;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import py.com.concepto.dao.DeliveryDao;
import py.com.concepto.model.entity.Delivery;
import py.com.concepto.model.entity.DeliveryItem;
import py.com.concepto.model.entity.ProdutoOpcional;
import py.com.concepto.model.entity.ProdutoSabor;
import py.com.concepto.model.entity.Troco;

@Path("/deliveryWS")
@Component(value = "deliveryWS")
public class DeliveryWS {

	@Autowired
	private DeliveryDao deliveryDao;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("saveOrUpdateDelivery")
	public String saveOrUpdate(Delivery delivery) {

		delivery = processaDelivery(delivery);
		return Response.status(200).toString();
	}

	private Delivery processaDelivery(Delivery delivery) {
		delivery.setDtDelivery(new Date());
		delivery.setConfirmado(false);
		delivery.setRejeitado(false);
		delivery.setEnviado(false);
		for (DeliveryItem item : delivery.getItens()) {
			item.setDelivery(delivery);
			if (item.getProdutoSabores() != null) {
				for (ProdutoSabor produtoSabor : item.getProdutoSabores()) {
					produtoSabor.setDeliveryItem(item);
				}
			}
			if (item.getProdutoOpcionais() != null) {
				for (ProdutoOpcional produtoOpcionais : item.getProdutoOpcionais()) {
					produtoOpcionais.setDeliveryItem(item);
				}
			}
		}
		for (Troco troco : delivery.getTrocos()) {
			troco.setDelivery(delivery);
		}

		// PROCESSA DELIVERY SABOR
		Delivery saveOrUpdate = deliveryDao.saveOrUpdate(delivery);

		return saveOrUpdate;

	}
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findUltimos5Deliverys")
	public List<Delivery> findUltimos5Deliverys(@QueryParam("idCliente")Long idCliente, @QueryParam("idEmpresa")Long idEmpresa){
		return deliveryDao.findUltimos5Deliverys(idCliente, idEmpresa);
	}
    
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("processaEvaluacao")
	public String processaEvaluacao(@QueryParam("idDelivery")Long idDelivery, @QueryParam("avaliacao")float avaliacao, @QueryParam("observacao")String observacao) {

		Delivery delivery = deliveryDao.findById(idDelivery);
		delivery.setAvaliacao(new BigDecimal(avaliacao));
		delivery.setComentarioCliente(observacao);
		deliveryDao.updateWithoutCascade(delivery);
		
		
		return Response.status(200).toString();
	}
	

	@PostConstruct
	public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
}
