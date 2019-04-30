package br.com.romulo.conceito.dto;

import java.io.Serializable;

import br.com.romulo.conceito.domain.Comunicacao;

public class ComunicacaoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer tipo;
	private String descricao;
	
	public ComunicacaoDTO() {}
	
	public ComunicacaoDTO(Comunicacao comunicacao) {
		if(comunicacao != null) {
			if(comunicacao.getTipo() != null) {
				setTipo(comunicacao.getTipo().getTipo());
				setDescricao(comunicacao.getDescricao());
			}
		}
		
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
}
