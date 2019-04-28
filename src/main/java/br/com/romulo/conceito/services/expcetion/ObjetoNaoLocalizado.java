package br.com.romulo.conceito.services.expcetion;

public class ObjetoNaoLocalizado extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjetoNaoLocalizado() {
		super("PESQUISA SEM NENHUM RESULTADO");
	}
	
	public ObjetoNaoLocalizado(String erro) {
		super(erro);
	}

	public ObjetoNaoLocalizado(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ObjetoNaoLocalizado(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjetoNaoLocalizado(Throwable cause) {
		super(cause);
	}
	
}
