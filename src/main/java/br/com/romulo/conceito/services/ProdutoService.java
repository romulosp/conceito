package br.com.romulo.conceito.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.romulo.conceito.domain.Produto;
import br.com.romulo.conceito.repositories.ProdutoRepository;
import br.com.romulo.conceito.services.expcetion.ObjetoNaoLocalizado;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	 public Produto buscarProdutoPorID(Integer idProduto){
		 Optional<Produto> obj = produtoRepository.findById(idProduto);
			return obj.orElseThrow(()-> new ObjetoNaoLocalizado());
	 }
	 
	 public List<Produto> listAll(){
		 return produtoRepository.findAll();
	 }
	 
	 
}
