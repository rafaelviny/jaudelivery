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

import py.com.concepto.dao.ProdutoDao;
import py.com.concepto.model.entity.Classificacao;
import py.com.concepto.model.entity.Produto;

@Path("/produtoWS")
@Component(value="produtoWS")
public class ProdutoWS {
	
	@Autowired
	private ProdutoDao produtoDao;	
	
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findProdutos")
    public List<Produto> findProdutos(){
        return produtoDao.findProdustosAtivos();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findProdutosByClassificacao")
    public List<Produto> findProdutosByClassificacao(@QueryParam("id")Long id){
    	List<Produto> findProdutosByClassificacao = produtoDao.findProdutosByClassificacao(id);
		return findProdutosByClassificacao;
    }
	
	
	
    
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
