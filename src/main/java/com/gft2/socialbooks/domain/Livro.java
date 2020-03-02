package com.gft2.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
public class Livro {
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private String nome;
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Date prublicacao;
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private String editora;
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private String resumo;
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@Transient // Evita que seja feita a relação entre livro e comentário.
	private List<Comentario> comentarios;
	
	
	
	
	public Livro() {}
	
	public Livro(String nome) {
		this.nome = nome;
	}




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
	public Date getPrublicacao() {
		return prublicacao;
	}
	public void setPrublicacao(Date prublicacao) {
		this.prublicacao = prublicacao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	private String autor;

}
