package com.gft2.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import com.gft2.socialbooks.domain.DetalhesErro;
import com.gft2.socialbooks.services.exceptions.AutorExistenteException;
import com.gft2.socialbooks.services.exceptions.AutorNaoExistenteException;
import com.gft2.socialbooks.services.exceptions.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	//Só criar esse método com o nome da excessão que você quer capturar: Ex: LivroNaoEncontradoException.
	@ExceptionHandler(LivroNaoEncontradoException.class) // Traz a class que será usada dentro - Qualquer parte da aplicação que lançar um 
	//"LivroNaoEncontradoException" será capiturado e trazido pra cá
	// ResponseEntity = Usa-se, pois ao capturar uma excessão deve-se retornar algo pro cliente
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontradoException (LivroNaoEncontradoException e, HttpServletRequest resquest) {
		//Nesse parenteses consta que essa classe tem a capacidade de receber 
		// o objeto  "LivroNaoEncontradoException " e tb "HttpServerErrorException"
		
		
		
		//Instaciar um objeto dessa (DetalheErro) classe e setar.
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O livro não pô ser encontrado!");
		erro.setTimestamp(System.currentTimeMillis()); //Para trazer a mensagem de erro em milesegundos
		erro.setMensagemDesenvolvedor("http//:erros.socialbooks.com/404");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
				}
	
	
	@ExceptionHandler(AutorExistenteException.class) //
	public ResponseEntity<DetalhesErro> handleAutorExistenteException (AutorExistenteException e, HttpServletRequest request) {
		
		
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Autor já existente!");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor("http//:erros.socialbooks.com/409");

		
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
				}
	
	@ExceptionHandler(AutorNaoExistenteException.class) //
	public ResponseEntity<DetalhesErro> handleAutorNaoExistenteException (AutorNaoExistenteException e, HttpServletRequest request) {
		
		
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Autor não econtrado!");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");

		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
				}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class) //
	public ResponseEntity<DetalhesErro> handlesDataIntegrityViolationException (DataIntegrityViolationException e, HttpServletRequest request) {
		
		
		DetalhesErro erro= new  DetalhesErro();
		erro.setStatus(400l);
		erro.setTitulo("Requisição inválida!");
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/400");

		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		
				}
				

}
