package br.com.farmacia.exception;

public class NaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private int errorCode;

	public NaoEncontradoException(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getCodigoErro() {
		return this.errorCode;
	}

}
