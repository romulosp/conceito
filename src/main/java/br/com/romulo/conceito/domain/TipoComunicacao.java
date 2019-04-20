package br.com.romulo.conceito.domain;

public enum TipoComunicacao {

	TELEFONE(1,"Telefone"),
	EMAIL(2,"E-MAIL"),
	CELULAR(3,"Celular"),
	;
	private Integer tipo;
	private String descricao;

	private TipoComunicacao(Integer tipo,String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static TipoComunicacao getTipoComunicacao(Integer tipo) {
		TipoComunicacao retorno = null;
		if(tipo != null) {
			for(TipoComunicacao tipoComunicacao : TipoComunicacao.values()) {
				if(tipoComunicacao.getTipo().equals(tipo)) {
					retorno = tipoComunicacao;
				}
			}
		}
		return retorno;
	}
	
}
