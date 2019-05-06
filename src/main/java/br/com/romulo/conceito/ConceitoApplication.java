package br.com.romulo.conceito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.romulo.conceito.domain.Categoria;
import br.com.romulo.conceito.domain.Cidade;
import br.com.romulo.conceito.domain.Cliente;
import br.com.romulo.conceito.domain.Comunicacao;
import br.com.romulo.conceito.domain.Endereco;
import br.com.romulo.conceito.domain.Estado;
import br.com.romulo.conceito.domain.EstadoPagamento;
import br.com.romulo.conceito.domain.ItemPedido;
import br.com.romulo.conceito.domain.PagamentoComBoleto;
import br.com.romulo.conceito.domain.PagamentoComCartao;
import br.com.romulo.conceito.domain.Pedido;
import br.com.romulo.conceito.domain.Produto;
import br.com.romulo.conceito.domain.ProdutoPedidoPK;
import br.com.romulo.conceito.domain.TipoCliente;
import br.com.romulo.conceito.domain.TipoComunicacao;
import br.com.romulo.conceito.repositories.CategoriaRepository;
import br.com.romulo.conceito.repositories.CidadeRepository;
import br.com.romulo.conceito.repositories.ClienteRepository;
import br.com.romulo.conceito.repositories.EnderecoRepository;
import br.com.romulo.conceito.repositories.EstadoRepository;
import br.com.romulo.conceito.repositories.ItemPedidoRepository;
import br.com.romulo.conceito.repositories.PagamentoComBoletoRepository;
import br.com.romulo.conceito.repositories.PagamentoComCartaoRepository;
import br.com.romulo.conceito.repositories.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoComCartaoRepository pagamentoComCartaoRepository;
	
	@Autowired
	private PagamentoComBoletoRepository pagamentoComBoletoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
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
		
		 
		Comunicacao emailCliente1 = new Comunicacao(TipoComunicacao.EMAIL);
		emailCliente1.setDescricao("romulos.p@hotmail.com");
		
		Comunicacao telefone = new Comunicacao(TipoComunicacao.CELULAR);
		telefone.setDescricao("61983753771");
		
		cliente1.setComunicacoes(Arrays.asList(emailCliente1, telefone));
		
		clienteRepository.saveAll(Arrays.asList(cliente1 ));
		
		enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2));
		
		
		Pedido pedido1 =  new Pedido(Calendar.getInstance(),endereco1,cliente1);
		
		PagamentoComCartao pagamentoComCartao = new PagamentoComCartao(null, EstadoPagamento.QUITADO.getCodigo(), pedido1, 6);
				pagamentoComCartao.setEstado(EstadoPagamento.QUITADO);
		
		pedido1.setPagamento(pagamentoComCartao);
		
		Pedido pedido2 =  new Pedido(Calendar.getInstance(),endereco2,cliente1);

		PagamentoComBoleto pagamentoComBoleto = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE.getCodigo(),pedido2,Calendar.getInstance(),null);
		
		pedido2.setPagamento(pagamentoComBoleto);
		
		pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));
	
		pagamentoComCartaoRepository.saveAll(Arrays.asList(pagamentoComCartao));
		
		pagamentoComBoletoRepository.saveAll(Arrays.asList(pagamentoComBoleto));
		
		ProdutoPedidoPK produtoID1 = new ProdutoPedidoPK(produto1, pedido1);
		ProdutoPedidoPK produtoID2 = new ProdutoPedidoPK(produto3, pedido1);
		ProdutoPedidoPK produtoID3 = new ProdutoPedidoPK(produto2, pedido2);
		
		
		ItemPedido itemPedido1 = new  ItemPedido(produtoID1, null, 1, 200.00);
		ItemPedido itemPedido2 = new  ItemPedido(produtoID2, null, 2, 80.00);
		ItemPedido itemPedido3 = new  ItemPedido(produtoID3, 100.00, 1, 800.00);
		
		
		itemPedidoRepository.saveAll(Arrays.asList(itemPedido1,itemPedido2,itemPedido3));
		
		
		pedido1.setItemPedido(itemPedido1);
		pedido2.setItemPedido(itemPedido2);
		
		pedidoRepository.saveAll(Arrays.asList(pedido1,pedido2));
	}
}

