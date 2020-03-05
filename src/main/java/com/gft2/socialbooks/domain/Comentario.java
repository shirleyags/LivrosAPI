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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comentario {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String texto;
	private String usuario;
	private Date data;
	
	@ManyToOne (fetch = FetchType.LAZY) //Um livro para muitos eventos
	// (fetch = FetchType.LAZY)  = Em uma estratégia de carregamento ansiosa, se carregarmos os dados do Usuário , 
	//ele também carregará todos os pedidos associados e os armazenará na memória .

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
