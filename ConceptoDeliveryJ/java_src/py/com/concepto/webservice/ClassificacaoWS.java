package py.com.concepto.webservice;

import java.util.List;

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

import py.com.concepto.dao.ClassificacaoDao;
import py.com.concepto.model.entity.Classificacao;

@Path("/classificacaoWS")
@Component(value="classificacaoWS")
public class ClassificacaoWS {
	
	@Autowired
	private ClassificacaoDao classificacaoDao;	
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findClassificacao")
    public List<Classificacao> findClassificacao(@QueryParam("idEmpresa")Long idEmpresa){
        return classificacaoDao.findClassificacoesAtivos(idEmpresa);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findClassificacaoByDescricao")
    public List<Classificacao> findClassificacaoByDescricao(@QueryParam("codigoBarra")String descricao){
    	return classificacaoDao.findByCondition(" DS_CLASSIFICACAO like '%" + descricao + "%'");
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("saveOrUpdate")
    public Classificacao saveOrUpdate(Classificacao classificacao){
    	return classificacaoDao.saveOrUpdate(classificacao);
    }
	
	
	
    
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
