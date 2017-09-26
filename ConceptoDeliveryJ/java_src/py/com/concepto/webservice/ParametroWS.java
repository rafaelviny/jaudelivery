package py.com.concepto.webservice;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import py.com.concepto.dao.ParametrosDao;
import py.com.concepto.model.entity.Parametros;

@Path("/parametroWS")
@Component(value="parametroWS")
public class ParametroWS {
	
	@Autowired
	private ParametrosDao parametrosDao;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findParametro")
    public Parametros findProdutoByCodigoBarra(@QueryParam("chave")String  chave){
        return parametrosDao.findParametro(chave);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findParametros")
    public List<Parametros> findParametros(){
    	return parametrosDao.findByCondition(" 1=1");
    }
    
	
    
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
