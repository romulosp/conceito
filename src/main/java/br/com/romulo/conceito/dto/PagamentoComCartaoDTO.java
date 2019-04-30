package br.com.romulo.conceito.dto;

import br.com.romulo.conceito.domain.PagamentoComCartao;

public class PagamentoComCartaoDTO extends PagamentoDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
	public  PagamentoComCartaoDTO() {}
	
	public PagamentoComCartaoDTO(Integer id, Integer estado, PedidoDTO pedido,Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	public PagamentoComCartaoDTO(PagamentoComCartao pagamentoComCartao) {
		super(pagamentoComCartao.getId(), pagamentoComCartao.getEstado().getCodigo(), new PedidoDTO(pagamentoComCartao.getPedido()));
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

}
