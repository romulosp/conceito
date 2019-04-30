package br.com.romulo.conceito.dto;

import java.io.Serializable;

import br.com.romulo.conceito.domain.ItemPedido;

public class ItemPedidoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProdutoDTO produto;
	private PedidoDTO pedido;
	
	private Double desconto;
	
	private Integer quantidade;
	
	private Double preco;
	
	public  ItemPedidoDTO() {}
	
	public ItemPedidoDTO(ItemPedido itemPedido) {
		if(itemPedido != null && itemPedido.getId() != null) {
			setProduto(new ProdutoDTO(itemPedido.getId().getProduto()));
			setPedido(new PedidoDTO(itemPedido.getId().getPedido()));
			setDesconto(itemPedido.getDesconto());
			setQuantidade(itemPedido.getQuantidade());
			setPreco(itemPedido.getPreco());
		}
	}
	
	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}
	 
}
