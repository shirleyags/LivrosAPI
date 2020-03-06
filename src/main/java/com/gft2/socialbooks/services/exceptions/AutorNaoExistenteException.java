package com.gft2.socialbooks.services.exceptions;

public class AutorNaoExistenteException extends RuntimeException {
	
	//RuntimeException = Excessão não checada

	

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public AutorNaoExistenteException(String mensagem) {

			super(mensagem); //super = Construtor da classe RuntimeException
		}

		public AutorNaoExistenteException(String mensagem, Throwable causa) {

			super(mensagem, causa);
		}

}
