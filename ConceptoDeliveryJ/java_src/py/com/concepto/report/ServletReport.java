package py.com.concepto.report;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.db1.myBatisPersistence.session.ConceptoSession;
import flex.messaging.io.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * 
 * @author root
 * @version
 */

@SuppressWarnings("serial")
public class ServletReport extends HttpServlet {

	private ServletContext sc;
	
	@Autowired
	private FactoryService factoryService = new FactoryService();

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.setProperty("java.awt.headless", "true"); 
		sc = config.getServletContext();
		
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(sc);

		AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext
				.getAutowireCapableBeanFactory();

		autowireCapableBeanFactory.configureBean(factoryService,
				"FactoryService");
		

	}

	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		List<?> dados = new ArrayList();
		File reportFile = null;	
		
		String sessioID = request.getParameter("sessionID");
		ConceptoSession.getInstance().setServletSessionID(sessioID);
		
		HashMap parameters = new HashMap();
		
		parameters.put("P_FILIAL", request.getParameter("filial"));
		parameters.put("P_USUARIO", request.getParameter("usuario"));
	
		parameters.put("P_RESUMIDO", new Boolean(request.getParameter("resumido")));
		parameters.put("P_FILTROS", request.getParameter("filtros"));
		parameters.put("P_MOEDA_FATURAMENTO", request.getParameter("moedaFaturamento"));
		
		String nomeRelatorio = request.getParameter("relatorio");
		String where = request.getParameter("where");
		
		/**
		 * definido qual metodo vai ser chamado para gerar os relatoriso
		 */
		
		/**
		 * diretorio do subrelatorio
		 */
		
		
		String path = this.getClass().getResource("/").getPath() +"/py/com/concepto/report/";
//		String path = getServletContext().getRealPath("/WEB-INF/reports/");
		parameters.put("SUBREPORT_DIR", path);
		
		if (nomeRelatorio.equals("RelatorioDelivery")) {
			dados = factoryService.deliveryService.findRelatorioDelivery(where);
		}
	
		System.out.println("reportFile " + reportFile);
		
		
		
		
		reportFile = new File(path +nomeRelatorio+".jasper");
//		reportFile = new File(getServletConteext().getRealPath("/WEB-INF/reports/"+nomeRelatorio+".jasper"));
		byte[] bytes = null;			
		JRDataSource jrds = new 
		JRBeanCollectionDataSource(dados);
		
		try {
			bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),
					parameters, jrds);
			
			
		} catch (JRException e) {
			e.printStackTrace();
		}
		
		

		if (bytes != null && bytes.length > 0) {
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream = response
					.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		}		
		
	}
	

}