package py.com.concepto.webservice;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import py.com.concepto.dao.ClienteDao;
import py.com.concepto.model.entity.Cliente;

@Path("/clienteWS")
@Component(value="clienteWS")
public class ClienteWS {
	
	
	@Autowired
	private ClienteDao clienteDao;	
    
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("saveOrUpdate")
    public Cliente saveOrUpdate(Cliente cliente){
    	 cliente = clienteDao.saveOrUpdate(cliente);
		return cliente;
    }
	
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findClienteByFacebookID")
    public Cliente findClienteByFacebookID(@QueryParam("idFacebook")String idFacebook){
        Cliente clienteByFacebookID = clienteDao.findClienteByFacebookID(idFacebook);
		return clienteByFacebookID;
    }
	
	
	
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
