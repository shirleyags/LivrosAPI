package com.gft2.socialbooks.resources;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gft2.socialbooks.domain.Autor;
import com.gft2.socialbooks.services.AutoresService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/autores")
public class AutoresResource {	

	@Autowired
	private AutoresService autoresService;

	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Autor>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(autoresService.listar());

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Autor esseAutor) {
		esseAutor = autoresService.salvar(esseAutor);

		URI umaUri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

		return ResponseEntity.created(umaUri).build();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Autor>> buscar(@PathVariable("id") Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(autoresService.buscar(id));
	}

}
