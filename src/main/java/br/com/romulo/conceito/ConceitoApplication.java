package br.com.romulo.conceito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.romulo.conceito.domain.Categoria;
import br.com.romulo.conceito.domain.Pedido;
import br.com.romulo.conceito.domain.Produto;
import br.com.romulo.conceito.repositories.CategoriaRepository;
import br.com.romulo.conceito.repositories.PedidoRepository;
import br.com.romulo.conceito.repositories.ProdutoRepository;

@SpringBootApplication
public class ConceitoApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired 
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ConceitoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		Categoria categoria1 = new Categoria(null, "INFORMATICA");
		Categoria categoria2 = new Categoria(null, "ESCRITORIO");
		listaCategoria.add(categoria1);
		listaCategoria.add(categoria2);
		categoriaRepository.saveAll(listaCategoria);
		
		
		List<Produto> listaProduto = new ArrayList<Produto>();
		 
		
		Produto produto1= new Produto(
				"Impressora", 
				800.00, 
				Arrays.asList(categoria1,categoria2)
		);
		

		Produto produto2= new Produto(
				"COMPUTADOR", 
				2000.00, 
				Arrays.asList(categoria1)
		);
		
		Produto produto3= new Produto(
				"MOUSE", 
				80.00, 
				Arrays.asList(categoria1)
		);
		
		listaProduto.add(produto1);
		listaProduto.add(produto2);
		listaProduto.add(produto3);
		produtoRepository.saveAll(listaProduto);
		
		
		
	}
}

