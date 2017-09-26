package py.com.concepto.webservice;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import py.com.concepto.dao.CidadeDao;
import py.com.concepto.model.entity.Cidade;

@Path("/cidadeWS")
@Component(value="cidadeWS")
public class CidadeWS {
	
	
	@Autowired
	private CidadeDao cidadeDao;	
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findCidadesAtivas")
    public List<Cidade> findCidadesAtivas(){
        return cidadeDao.findCidadesAtivas();
    }
	
	
	
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
