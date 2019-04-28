package br.com.romulo.conceito.resources.exception;

import java.io.Serializable;
import java.util.Calendar;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardErro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonFormat( pattern = "dd/MM/yyyy HH:MM")
	private Calendar instante;
	
	private Integer httpStatus;
	
	private String mensagemErro;
	
	public StandardErro(String mesnagemErro, HttpStatus httpStatus) {
		this.setInstante(Calendar.getInstance());
		this.setHttpStatus(httpStatus.value());
		this.setMensagemErro(mesnagemErro);
	}
	
	public Calendar getInstante() {
		return instante;
	}
	public void setInstante(Calendar instante) {
		this.instante = instante;
	}
	public Integer getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMensagemErro() {
		return mensagemErro;
	}
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
}
