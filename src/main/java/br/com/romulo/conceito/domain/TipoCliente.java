package br.com.romulo.conceito.domain;

public enum TipoCliente {
	PESSOA_FISICA(1,"PESSOA FÍSICA"),
	PESSOA_JURIDICA(2," PESSOA JURIDICA")
	;
	
	private Integer codigo;
	private String descricao;

	private TipoCliente(Integer codigo,String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}	
	
	public static TipoCliente getTipoCliente(Integer codigo) {
		TipoCliente retorno = null;
		if(codigo != null) {
			for(TipoCliente tipoCliente : TipoCliente.values()) {
				if(tipoCliente.getCodigo().equals(codigo)) {
					return tipoCliente;
				}
			}
		}
		return retorno;
	}
	
}
