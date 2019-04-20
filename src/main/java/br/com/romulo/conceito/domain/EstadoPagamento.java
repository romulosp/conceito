package br.com.romulo.conceito.domain;

public enum EstadoPagamento {
	PENDENTE(1,"PENDÊNTE"),
	QUITADO(2,"QUITADO"),
	CANCELADO(3,"CANCELADO"),
	
	;
	
	private Integer codigo;
	private String descricao;

	private EstadoPagamento(Integer codigo,String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}	
	
	public static EstadoPagamento getEstadoPagamento(Integer codigo) {
		EstadoPagamento retorno = null;
		if(codigo != null) {
			for(EstadoPagamento estadoPagamento : EstadoPagamento.values()) {
				if(estadoPagamento.getCodigo().equals(codigo)) {
					return estadoPagamento;
				}
			}
		}
		return retorno;
	}
}
