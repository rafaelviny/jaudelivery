package py.com.concepto.util.exception;

/**
 * classe responsavel por tratar excessoes 
 * @author Rafael
 *
 */
public class ConceptoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	
	public ConceptoException() {
		super();
	}
	
	public ConceptoException(String mensagem) {
		super(mensagem);
		this.mensagem = mensagem;
	}
	
	
	
	@Override
	public String getMessage() {
	
		return getMensagem();
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getMensagem() {
		return mensagem;
	}

}
