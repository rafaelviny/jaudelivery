package py.com.concepto.webservice;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Path("/saborWS")
@Component(value="saborWS")
public class SaborWS {
	
    
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
