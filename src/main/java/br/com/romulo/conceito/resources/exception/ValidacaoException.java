package br.com.romulo.conceito.resources.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ValidacaoException extends StandardErro{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<FieldValidacao> listErroValidacao;
	
	public ValidacaoException(String mesnagemErro, HttpStatus httpStatus) {
		super(mesnagemErro, httpStatus);
		listErroValidacao = new ArrayList<>();
	}
	
	public List<FieldValidacao> getListErroValidacao() {
		return listErroValidacao;
	}
	
	
	

}
