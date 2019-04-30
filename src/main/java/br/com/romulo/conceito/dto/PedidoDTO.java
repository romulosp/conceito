package br.com.romulo.conceito.dto;

import java.io.Serializable;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.romulo.conceito.domain.Pedido;

public class PedidoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:MM")
	private Calendar instante;
	private EnderecoDTO endereco;
	private ClienteDTO cliente;
	private PagamentoDTO pagamento;
	private ItemPedidoDTO itemPedido;
	
	public PedidoDTO() {}
	
	public PedidoDTO(Calendar instante, EnderecoDTO endereco, ClienteDTO cliente, PagamentoDTO pagamento) {
		super();
		this.instante = instante;
		this.endereco = endereco;
		this.cliente = cliente;
		this.pagamento = pagamento;
	}

	public PedidoDTO(Calendar instante, EnderecoDTO endereco, ClienteDTO cliente) {
		super();
		this.instante = instante;
		this.endereco = endereco;
		this.cliente = cliente;
	}

	public PedidoDTO(Pedido pedido) {
		if(pedido != null) {
			setInstante(pedido.getInstante());
			if(pedido.getEndereco() != null) {
				setEndereco(new EnderecoDTO(pedido.getEndereco()));
			}
			if(pedido.getCliente() != null) {
				setCliente(new ClienteDTO(pedido.getCliente()));
			}
		}
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getInstante() {
		return instante;
	}

	public void setInstante(Calendar instante) {
		this.instante = instante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoDTO other = (PedidoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public EnderecoDTO getEndereco() {
		return endereco;
	}


	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}


	public ClienteDTO getCliente() {
		return cliente;
	}


	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}


	public PagamentoDTO getPagamento() {
		return pagamento;
	}


	public void setPagamento(PagamentoDTO pagamento) {
		this.pagamento = pagamento;
	}


	public ItemPedidoDTO getItemPedido() {
		return itemPedido;
	}


	public void setItemPedido(ItemPedidoDTO itemPedido) {
		this.itemPedido = itemPedido;
	}

 
}
