package br.com.romulo.conceito.domain;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat( pattern = "dd/MM/yyyy HH:MM")
	@Temporal(TemporalType.DATE)
	private Calendar dataPagamento;
	
	@JsonFormat( pattern = "dd/MM/yyyy HH:MM")
	@Temporal(TemporalType.DATE)
	private Calendar dataVencimento;

	public PagamentoComBoleto() {}
	
	public PagamentoComBoleto(Integer id, Integer estado, Pedido pedido,Calendar dataPagamento, Calendar dataVencimento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
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
