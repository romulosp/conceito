package br.com.romulo.conceito.resources.exception;

import java.io.Serializable;

public class FieldValidacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String campo;
	private String mensagem;
		
	public FieldValidacao(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}
	
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
