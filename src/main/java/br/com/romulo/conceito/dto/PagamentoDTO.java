package br.com.romulo.conceito.dto;

import java.io.Serializable;

import br.com.romulo.conceito.domain.EstadoPagamento;
import br.com.romulo.conceito.domain.Pagamento;

public abstract class PagamentoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
 
	private Integer id;
	
	private Integer estado;
	 
	private PedidoDTO pedido;

	public PagamentoDTO() {}
	
	public PagamentoDTO(Integer id, Integer estado, PedidoDTO pedido) {
		super();
		this.id = id;
		this.estado = estado;
		this.pedido = pedido;
	}
	
	public PagamentoDTO(Pagamento pagamento) {
		if(pagamento != null) {
			setId(pagamento.getId());
			setEstado(pagamento.getEstado().getCodigo());
			setPedido(new PedidoDTO(pagamento.getPedido()));
		}
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.getEstadoPagamento(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCodigo();
	}

	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
}
