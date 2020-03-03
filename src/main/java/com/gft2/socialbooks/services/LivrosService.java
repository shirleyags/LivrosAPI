package com.gft2.socialbooks.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gft2.socialbooks.domain.Livro;
import com.gft2.socialbooks.repository.LivrosRepository;
import com.gft2.socialbooks.services.exceptions.LivroNaoEncontradoException;


@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository; 
	
	
	public List<Livro> listar(){
		return livrosRepository.findAll();
		
	}
	
	
	
	public Optional<Livro> buscar(Long id){
		Optional<Livro> cadaLivro = livrosRepository.findById(id); 
		if(cadaLivro.isEmpty()) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado!"); 
		}
		return cadaLivro;
}
	
	public Livro salvar(Livro cadalivro){ 
		cadalivro.setId(null); //Setar igual a nulo para garantir que será criada uma instância nova, não alterar um objeto já criado. 
		return  livrosRepository.save(cadalivro);
	
	}
	
	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e){
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado!");
		}
		
	} //Por que não precisa do return???
	
	public void atualizar(Livro cadaLivro) { //Por que aqui não rebece o Long Id???
		verificarExistenciaLivro(cadaLivro);
		livrosRepository.save(cadaLivro);
		
	}
	
	private void verificarExistenciaLivro(Livro cadaLivro) {
		buscar(cadaLivro.getId());
	}
	

}
