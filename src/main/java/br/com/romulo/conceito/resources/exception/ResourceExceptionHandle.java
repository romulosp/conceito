package br.com.romulo.conceito.resources.exception;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.romulo.conceito.services.expcetion.ObjetoNaoLocalizado;
import br.com.romulo.conceito.services.expcetion.SegurancaIntegridadeException;

@ControllerAdvice
public class ResourceExceptionHandle {

	private static final String VALIDACAO_ERRO = "ERRO DE VALIDAÇÃO";

	@ExceptionHandler(ObjetoNaoLocalizado.class)
	public ResponseEntity<StandardErro> objetoNaoLocalizado(ObjetoNaoLocalizado obj, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardErro(obj.getMessage(), HttpStatus.NOT_FOUND));
	}
	
	
	@ExceptionHandler(SegurancaIntegridadeException.class)
	public ResponseEntity<StandardErro> segurancaIntegridade(SegurancaIntegridadeException e, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandardErro(e.getMessage(),HttpStatus.BAD_REQUEST));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidacaoException> validation(MethodArgumentNotValidException e, HttpServletRequest request){
		
		ValidacaoException validacaoException = new ValidacaoException(VALIDACAO_ERRO, HttpStatus.BAD_REQUEST);
		
		e.getBindingResult().
							getFieldErrors().stream().
													  forEach(fieldErro -> validacaoException.getListErroValidacao()
						.add(new FieldValidacao(fieldErro.getField(),fieldErro.getDefaultMessage())));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validacaoException );
	}
	
	
}
