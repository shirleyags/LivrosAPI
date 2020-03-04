package com.gft2.socialbooks.resources;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gft2.socialbooks.domain.Livro;
import com.gft2.socialbooks.repository.LivrosRepository;
import com.gft2.socialbooks.services.LivrosService;
import com.gft2.socialbooks.services.exceptions.LivroNaoEncontradoException;

@RestController
@RequestMapping("/livros")
public class LivrosResources {
	
	@Autowired
	LivrosService livrosService;
	
	
	
	@RequestMapping(method = RequestMethod.GET) // VAI PEGAR DO BANCO E FAZER APARECER
	public ResponseEntity<List<Livro>> listar() {
//		Livro l1 = new Livro("Rest Aplicado");
//		Livro l2 = new Livro("Git Aplicado");
//		
//		Livro[] livros = {l1, l2};
//		return Arrays.asList(livros)
//		A PARTE DE BAIXO É O RESUMO DA PARTE DE CIMA
		
		return ResponseEntity.status(HttpStatus.OK).body(livrosService.listar()); //Usa-se findAll(), pois se refere a uma lista
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST) //É POST PORQUE VAI PEGAR DA URL E SALVAR
	public ResponseEntity<Void> salvar(@RequestBody Livro cadalivro){ 
		livrosService.salvar(cadalivro);
		
		URI umaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cadalivro.getId()).toUri();
		
		return ResponseEntity.created(umaUri).build();
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET) //Trazer é GET
		public ResponseEntity<?> buscar(@PathVariable("id")Long id){
		Optional<Livro> cadaLivro = livrosService.buscar(id);
	
			return ResponseEntity.status(HttpStatus.OK).body(cadaLivro);
		}
	
	
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<Void> deletar(@PathVariable("id")Long id) {
			livrosService.deletar(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.PUT) 
	public  ResponseEntity<Void> atualizar(@RequestBody Livro cadaLivro, @PathVariable("id")Long id) {
		cadaLivro.setId(id);
		livrosService.atualizar(cadaLivro);
	return ResponseEntity.noContent().build();
	}
}

