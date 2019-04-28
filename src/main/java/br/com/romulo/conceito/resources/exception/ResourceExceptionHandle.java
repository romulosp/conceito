package br.com.romulo.conceito.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.romulo.conceito.services.expcetion.ObjetoNaoLocalizado;
import br.com.romulo.conceito.services.expcetion.SegurancaIntegridadeException;

@ControllerAdvice
public class ResourceExceptionHandle {

	@ExceptionHandler(ObjetoNaoLocalizado.class)
	public ResponseEntity<StandardErro> objetoNaoLocalizado(ObjetoNaoLocalizado obj, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardErro(obj.getMessage(), HttpStatus.NOT_FOUND));
	}
	
	
	@ExceptionHandler(SegurancaIntegridadeException.class)
	public ResponseEntity<StandardErro> segurancaIntegridade(SegurancaIntegridadeException e, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardErro(e.getMessage(),HttpStatus.BAD_REQUEST));
	}
}
