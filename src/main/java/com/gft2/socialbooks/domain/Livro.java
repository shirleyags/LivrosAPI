package com.gft2.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
public class Livro {
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message="O campo nome não pode ser vazio.")
	private String nome;
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@JsonFormat(pattern="dd/MM/yyyy")
	@NotEmpty(message="O campo de publicação é de preenchimento obrigatório.")
	private Date publicacao;
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@NotEmpty(message="O campo da editora é de preenchimento obrigatório.")
	private String editora;
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@NotEmpty(message="O campo de resumo é de preenchimento obrigatório.")
	@Size(max=1500, message="O campo de resumo não pode conter mais de 1500 caracteres.")
	private String resumo;
	@JsonInclude(JsonInclude.Include.NON_EMPTY) 
	//@Transient // Evita que seja feita a relação entre livro e comentário.
	@OneToMany(mappedBy = "esseLivro") //Livro tem varios comentários. É para indicar qual é o lado inverso ou não dominante da relação.
	private List<Comentario> comentarios;
	@ManyToOne
	@JoinColumn(name="AUTOR_ID")
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Autor esseAutor;
	
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
	public Date getPublicacao() {
		return publicacao;
	}
	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
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
	public Autor getEsseAutor() {
		return esseAutor;
	}
	public void setEsseAutor(Autor esseAutor) {
		this.esseAutor = esseAutor;
	}
	
	
	

	

}
