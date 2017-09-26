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

import py.com.concepto.dao.FilialDao;
import py.com.concepto.model.entity.Filial;

@Path("/filialWS")
@Component(value = "filialWS")
public class FilialWS {

	@Autowired
	private FilialDao filialDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("findFiliaisByCidade")
	public List<Filial> findFiliaisByCidade(@QueryParam("idCidade") Long idCidade) {
		List<Filial> findFiliaisByCidade = filialDao.findFiliaisByCidade(idCidade);
		return findFiliaisByCidade;
	}

	@PostConstruct
	public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
}
