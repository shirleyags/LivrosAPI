package com.gft2.socialbooks.resources;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gft2.socialbooks.domain.Livro;
import com.gft2.socialbooks.repository.LivrosRepository;

@RestController
@RequestMapping("/livros")
public class LivrosResources {
	
	@Autowired
	private LivrosRepository livrosRepository; 
	
	
	@RequestMapping(method = RequestMethod.GET) // VAI PEGAR DO BANCO E FAZER APARECER
	public List<Livro> listar() {
//		Livro l1 = new Livro("Rest Aplicado");
//		Livro l2 = new Livro("Git Aplicado");
//		
//		Livro[] livros = {l1, l2};
//		return Arrays.asList(livros)
//		A PARTE DE BAIXO É O RESUMO DA PARTE DE CIMA
		
		return livrosRepository.findAll(); //Usa-se findAll(), pois se refere a uma lista
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST) //É POST PORQUE VAI PEGAR DA URL E SALVAR
	public void salvar(@RequestBody Livro cadalivro){ 
		livrosRepository.save(cadalivro);

	}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.GET) //Trazer é GET
		public Livro buscar(@PathVariable("id")Long id){
			return livrosRepository.findById(id).get(); 
		}
	
	@RequestMapping(value ="/{id}", method = RequestMethod.DELETE) 
	public void deletar(@PathVariable("id")Long id) {
		livrosRepository.deleteById(id);
	}
	

}
