package br.com.romulo.conceito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.romulo.conceito.domain.Categoria;
import br.com.romulo.conceito.domain.Cidade;
import br.com.romulo.conceito.domain.Cliente;
import br.com.romulo.conceito.domain.Endereco;
import br.com.romulo.conceito.domain.Estado;
import br.com.romulo.conceito.domain.Produto;
import br.com.romulo.conceito.domain.TipoCliente;
import br.com.romulo.conceito.repositories.CategoriaRepository;
import br.com.romulo.conceito.repositories.CidadeRepository;
import br.com.romulo.conceito.repositories.ClienteRepository;
import br.com.romulo.conceito.repositories.EnderecoRepository;
import br.com.romulo.conceito.repositories.EstadoRepository;
import br.com.romulo.conceito.repositories.ProdutoRepository;

@SpringBootApplication
public class ConceitoApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired 
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired 
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
//	@Autowired
//	private PedidoRepository pedidoRepository;
	
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
		
		 
		Estado estado1 = new Estado(null, "MINAS GERAIS");
		Estado estado2 = new Estado(null, "SÃO PAULO");
		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		
		
		Cidade cidade1 = new Cidade(null, "URBELANDIA", estado1);
		Cidade cidade2 = new Cidade(null, "SÃO PAULO", estado2);
		Cidade cidade3 = new Cidade(null, "CAMPINAS", estado2);
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		
		Cliente cliente1 = new Cliente("Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA.getCodigo());
		
		Endereco endereco1 = new Endereco("Rua Flores", "300", "Apto 203", "Jardim", "38220834");
		
		endereco1.setCidade(cidade1);
		endereco1.setCliente(cliente1);
		Endereco endereco2 = new Endereco("Avenida matos", "105", "Sala 800", "Centro", "38777012");
		endereco2.setCliente(cliente1);
		endereco2.setCidade(cidade2);
		cliente1.setEnderecos(Arrays.asList(endereco1,endereco2));
		
		Set<String> telefones = new HashSet<>();
		telefones.add("27363323");
		telefones.add("93838393");
		cliente1.setTelefones(telefones);
		
		clienteRepository.saveAll(Arrays.asList(cliente1 ));
		
		enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2));
	}
}

