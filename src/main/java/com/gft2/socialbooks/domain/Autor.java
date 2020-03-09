package com.gft2.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="O campo nome não pode ser vazio.")
	private String nome;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@JsonFormat(pattern="dd/MM/yyyy")
	@NotEmpty(message="O campo data de nascimento é de preenchimento obrigatório.")
	private Date dataNascimento;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@NotEmpty(message="Esse campo é de preenchimento obrigatório.")
	private String nacionalidade;

	
	@OneToMany(mappedBy = "esseAutor")
	@JsonIgnore
	private List<Livro> livros;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}
