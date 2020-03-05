package com.gft2.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft2.socialbooks.domain.Comentario;
import com.gft2.socialbooks.domain.Livro;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {
	
	

}
