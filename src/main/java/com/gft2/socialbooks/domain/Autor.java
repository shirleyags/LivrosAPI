package com.gft2.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ManyToAny;


public class Autor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	
	private Date dataNascimento;
	private String nacionalidade;
	
	
	//private List<Livro> livros;

	

}
