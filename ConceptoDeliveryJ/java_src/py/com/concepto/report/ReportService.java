package py.com.concepto.report;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("reportService")
@Transactional(rollbackFor = Exception.class)
public class ReportService {

	

}
