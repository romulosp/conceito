package br.com.romulo.conceito.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

import br.com.romulo.conceito.dto.ComunicacaoDTO;

@Embeddable
public class Comunicacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer tipo;
	private String descricao;
	
	public Comunicacao() {}
	public Comunicacao(TipoComunicacao tipoComunicacao) {
		setTipo(tipoComunicacao);
	}
	
	
	
	public Comunicacao(ComunicacaoDTO comunicacaoDTO) {
		
		if(comunicacaoDTO != null) {
			setTipo(TipoComunicacao.getTipoComunicacao(comunicacaoDTO.getTipo()));
			setDescricao(comunicacaoDTO.getDescricao());
		}
	}
	
	public TipoComunicacao getTipo() {
		return TipoComunicacao.getTipoComunicacao(tipo);
	}
	
	public void setTipo(TipoComunicacao tipo) {
		this.tipo = tipo.getTipo();
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Comunicacao other = (Comunicacao) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
 
	@Override
	public String toString() {
		return getTipo().getDescricao()+ " : "+ getDescricao();
	}
}
