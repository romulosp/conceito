package br.com.romulo.conceito.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.romulo.conceito.domain.Produto;
import br.com.romulo.conceito.dto.ProdutoDTO;
import br.com.romulo.conceito.services.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value = "/{idProduto}",method = RequestMethod.GET)
	public ResponseEntity<ProdutoDTO> listarProdutoPorID(@PathVariable("idProduto") Integer idProduto){
		return ResponseEntity.ok().body(new ProdutoDTO(produtoService.buscarProdutoPorID(idProduto)));
	}
	
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	public ResponseEntity<?> listAll(){
		List<Produto> listAllProduto = produtoService.listAll();
		List<ProdutoDTO> listAllProdutoDTO = listAllProduto.stream().map(produto -> new ProdutoDTO(produto)).collect(Collectors.toList());
		return ResponseEntity.ok().body(ResponseEntity.ok().body(listAllProdutoDTO));
	}
}
