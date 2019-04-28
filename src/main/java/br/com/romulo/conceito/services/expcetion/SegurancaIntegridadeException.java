package br.com.romulo.conceito.services.expcetion;

import org.springframework.dao.DataIntegrityViolationException;

public class SegurancaIntegridadeException extends DataIntegrityViolationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SegurancaIntegridadeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public SegurancaIntegridadeException(String msg) {
		super(msg);
	}
	 
}
