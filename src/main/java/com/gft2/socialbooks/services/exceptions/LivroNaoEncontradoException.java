package com.gft2.socialbooks.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException  {
	
	//RuntimeException = Excessão não checada

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LivroNaoEncontradoException(String mensagem) {

		super(mensagem); //super = Construtor da classe RuntimeException
	}

	public LivroNaoEncontradoException(String mensagem, Throwable causa) {

		super(mensagem, causa);
	}

}
