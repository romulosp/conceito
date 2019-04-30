package br.com.romulo.conceito.dto;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.romulo.conceito.domain.PagamentoComBoleto;

public class PagamentoComBoletoDTO extends PagamentoDTO {
	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern = "dd/MM/yyyy HH:MM")
	private Calendar dataPagamento;
	@JsonFormat(pattern = "dd/MM/yyyy HH:MM")
	private Calendar dataVencimento;

	public PagamentoComBoletoDTO() {}
	
	public PagamentoComBoletoDTO(Integer id, Integer estado, PedidoDTO pedido,Calendar dataPagamento, Calendar dataVencimento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}
	
	public PagamentoComBoletoDTO(PagamentoComBoleto pagamentoComBoleto) {
		super(pagamentoComBoleto.getId(), pagamentoComBoleto.getEstado().getCodigo(), new PedidoDTO(pagamentoComBoleto.getPedido()));
		if(pagamentoComBoleto != null) {
			setDataPagamento(pagamentoComBoleto.getDataPagamento());
			setDataVencimento(pagamentoComBoleto.getDataVencimento());
		}
		
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
}
