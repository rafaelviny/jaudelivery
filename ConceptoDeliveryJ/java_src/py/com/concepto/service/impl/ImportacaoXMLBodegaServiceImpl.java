package py.com.concepto.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thoughtworks.xstream.XStream;

import py.com.concepto.dao.ProdutoDao;
import py.com.concepto.model.entity.Produto;
import py.com.concepto.model.entity.Sabor;
import py.com.concepto.model.entity.dto.ExportacaoJAUDeliveryDto;
import py.com.concepto.service.ImportacaoXMLBodegaService;

@Service(value = "importacaoXMLBodegaService")
@Transactional(rollbackFor = Exception.class)
public class ImportacaoXMLBodegaServiceImpl implements ImportacaoXMLBodegaService{
	
	@Autowired
	private ProdutoDao produtoDao;
	
	@Override
	public void processaXML(String xml, Long idFilial){
		XStream xmlProvider = new XStream();
		List<ExportacaoJAUDeliveryDto> list = (List<ExportacaoJAUDeliveryDto>) xmlProvider.fromXML(xml);
		
		for (ExportacaoJAUDeliveryDto dto : list) {
			Produto produto = produtoDao.findById(dto.getCodigoJauDelivery(), idFilial);
			if(produto != null){
				produto.setDescricao(dto.getNomeProduto());
				produto.setTitulo(dto.getNomeProduto());
				// SE OS PRECOS FOREM IGUAIS SETA PRODUTO COMO PRECO VENDA E ELIMINA OS SABORES
				if(dto.getPreco01().compareTo(dto.getPreco02()) == 0 || dto.getPreco02().compareTo(new BigDecimal(0)) == 0){
					produto.setVlPreco(dto.getPreco01());
					produto.setMaiorPreco(false);
					if(produto.getSabores().size() > 0){
						for (Sabor sabor : produto.getSabores()) {
							sabor.setAtivo(false);
						}
					}
				}else{
					if(produto.getSabores().size() == 0){
						Sabor sabor = new Sabor();
						sabor.setAtivo(true);
						sabor.setDescricao("UNIDAD");
						sabor.setProduto(produto);
						sabor.setTitulo(dto.getNomeProduto());
						sabor.setVlPreco(dto.getPreco01());
						
						Sabor saborCaja = new Sabor();
						saborCaja.setAtivo(true);
						saborCaja.setDescricao("CAJA");
						saborCaja.setProduto(produto);
						saborCaja.setTitulo(dto.getNomeProduto());
						saborCaja.setVlPreco(dto.getPreco02());
						
						produto.getSabores().add(saborCaja);
						produto.getSabores().add(sabor);

					}else{
						for (Sabor sabor : produto.getSabores()) {
							if(sabor.getDescricao().compareTo("UNIDAD") == 0){
								sabor.setVlPreco(dto.getPreco01());
							}
							if(sabor.getDescricao().compareTo("CAJA") == 0){
								sabor.setVlPreco(dto.getPreco02());
							}
						}
					}
					produto.setQtdMaximaSabor(1L);
					produto.setMaiorPreco(true);
				}
				produtoDao.update(produto);
			}
		}
		
	}

}
