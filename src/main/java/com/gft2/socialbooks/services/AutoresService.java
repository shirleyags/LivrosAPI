package com.gft2.socialbooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.gft2.socialbooks.repository.AutoresRepository;
import com.gft2.socialbooks.services.exceptions.AutorExistenteException;
import com.gft2.socialbooks.services.exceptions.AutorNaoExistenteException;
import com.gft2.socialbooks.domain.Autor;

@Service
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	public List<Autor> listar(){
		return autoresRepository.findAll();
		
	}
	
	public Autor salvar( Autor esseAutor) {
		if(esseAutor.getId() != null){
			
			Autor a = autoresRepository.findById(esseAutor.getId()).get();
			
			if(a !=null) {
				throw new AutorExistenteException("O autor já existe.");
			}
			
		}
		return autoresRepository.save(esseAutor) ;
	}
	
	public Autor buscar(Long id) {
		Autor autor = autoresRepository.findById(id).get();
			if(autor==null) {
				throw new AutorNaoExistenteException("Autor não pôde ser encontrado");
			}
			
			return autor;
			
		}
	
	
	
}
