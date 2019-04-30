package br.com.romulo.conceito.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.romulo.conceito.domain.PagamentoComBoleto;
import br.com.romulo.conceito.domain.PagamentoComCartao;
import br.com.romulo.conceito.dto.PagamentoComBoletoDTO;
import br.com.romulo.conceito.dto.PagamentoComCartaoDTO;
import br.com.romulo.conceito.services.PagamentoService;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoResource {
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@RequestMapping(value = "/boleto/{idPagamentoCartao}",method = RequestMethod.GET)
	public ResponseEntity<PagamentoComBoletoDTO> listarPagamentoComBoletoPorID(@PathVariable("idPagamentoCartao") Integer idPagamento){
		return ResponseEntity.ok().body(new PagamentoComBoletoDTO(pagamentoService.buscarPagamentoComBoletoPorID(idPagamento)));
	}
	
	@RequestMapping(value = "/cartao/{idPagamentoBoleto}",method = RequestMethod.GET)
	public ResponseEntity<PagamentoComCartaoDTO> listarPagamentoComCartaoPorID(@PathVariable("idPagamentoBoleto") Integer idPagamento){
		return ResponseEntity.ok().body(new PagamentoComCartaoDTO(pagamentoService.buscarPagamentoComCartaoPorID(idPagamento)));
	}
	
	@RequestMapping(value = "/cartao/all",method = RequestMethod.GET)
	public ResponseEntity<?> listAllPagamentoComCartao(){
		List<PagamentoComCartao> listAllPagamentoComCartao = pagamentoService.listAllPagamentoComCartao();
		List<PagamentoComCartaoDTO> listAllPagamentoComCartaoDTO = listAllPagamentoComCartao.stream().map(pagamentoCartao -> new PagamentoComCartaoDTO(pagamentoCartao)).collect(Collectors.toList());
		return ResponseEntity.ok().body(ResponseEntity.ok().body(listAllPagamentoComCartaoDTO));
	}
	
	@RequestMapping(value = "/boleto/all",method = RequestMethod.GET)
	public ResponseEntity<?> listAllPagamentoComBoleto(){
		List<PagamentoComBoleto> listAllPagamentoComBoleto = pagamentoService.listAllPagamentoComBoleto();
		List<PagamentoComBoletoDTO> listAllPagamentoComBoletoDTO = listAllPagamentoComBoleto.stream().map(pagamentoBoleto -> new PagamentoComBoletoDTO(pagamentoBoleto)).collect(Collectors.toList());
		return ResponseEntity.ok().body(ResponseEntity.ok().body(listAllPagamentoComBoletoDTO));
	}
}
