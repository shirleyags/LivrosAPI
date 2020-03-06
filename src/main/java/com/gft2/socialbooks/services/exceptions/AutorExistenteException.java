package com.gft2.socialbooks.services.exceptions;

public class AutorExistenteException extends RuntimeException {
	
	//RuntimeException = Excessão não checada

	

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public AutorExistenteException(String mensagem) {

			super(mensagem); //super = Construtor da classe RuntimeException
		}

		public AutorExistenteException(String mensagem, Throwable causa) {

			super(mensagem, causa);
		}

}
