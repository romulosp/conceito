package br.com.romulo.conceito.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.romulo.conceito.domain.Produto;
import br.com.romulo.conceito.services.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/{idProduto}",method = RequestMethod.GET)
	public ResponseEntity<Produto> listarProdutoPorID(@PathVariable("idProduto") Integer idProduto){
		return ResponseEntity.ok().body(produtoService.buscarProdutoPorID(idProduto));
	}
	
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	public ResponseEntity<?> listAll(){
		return ResponseEntity.ok().body(ResponseEntity.ok().body(produtoService.listAll()));
	}
}
