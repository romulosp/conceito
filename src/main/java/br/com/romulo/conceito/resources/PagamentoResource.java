package br.com.romulo.conceito.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.romulo.conceito.domain.PagamentoComBoleto;
import br.com.romulo.conceito.domain.PagamentoComCartao;
import br.com.romulo.conceito.services.PagamentoService;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoResource {
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@RequestMapping(value = "/boleto/{idPagamentoCartao}",method = RequestMethod.GET)
	public ResponseEntity<PagamentoComBoleto> listarPagamentoComBoletoPorID(@PathVariable("idPagamentoCartao") Integer idPagamento){
		return ResponseEntity.ok().body(pagamentoService.buscarPagamentoComBoletoPorID(idPagamento));
	}
	
	@RequestMapping(value = "/cartao/{idPagamentoBoleto}",method = RequestMethod.GET)
	public ResponseEntity<PagamentoComCartao> listarPagamentoComCartaoPorID(@PathVariable("idPagamentoBoleto") Integer idPagamento){
		return ResponseEntity.ok().body(pagamentoService.buscarPagamentoComCartaoPorID(idPagamento));
	}
	
	@RequestMapping(value = "/cartao/all",method = RequestMethod.GET)
	public ResponseEntity<?> listAllPagamentoComCartao(){
		return ResponseEntity.ok().body(ResponseEntity.ok().body(pagamentoService.listAllPagamentoComCartao()));
	}
	
	@RequestMapping(value = "/boleto/all",method = RequestMethod.GET)
	public ResponseEntity<?> listAllPagamentoComBoleto(){
		return ResponseEntity.ok().body(ResponseEntity.ok().body(pagamentoService.listAllPagamentoComBoleto()));
	}
}
