package com.gft2.socialbooks.domain;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Comentario {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@NotEmpty(message="O campo de texto é de preenchimento obrigatório.")
	@Size(max=1500, message="O campo de texto não pode conter mais de 1500 caracteres.")
	private String texto;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private String usuario;
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date data;
	
	
	@ManyToOne (fetch = FetchType.LAZY) //Um livro para muitos eventos
	// (fetch = FetchType.LAZY)  = Em uma estratégia de carregamento ansiosa, se carregarmos os dados do Usuário , 
	//ele também carregará todos os pedidos associados e os armazenará na memória .
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@JoinColumn(name="LIVRO_ID") // indica que a classe na qual você está utilizando-a é 
	//a dona ou o lado forte do relacionamento. Isso apenas adiciona uma coluna estrangeira ao lado forte.
	@JsonIgnore //Não precisa colocar essa informação do livro no comentário - MUITO IMPORTANTE
	private Livro esseLivro;
	
	
	
	
	public Livro getEsseLivro() {
		return esseLivro;
	}
	public void setEsseLivro(Livro esseLivro) {
		this.esseLivro = esseLivro;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

}
