package com.alura.forumhub.forumhub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TopicoRepository extends JpaRepository<Topico,Long>{

    boolean existsByTituloAndMensagem(String titulo,String mensagem);

    Page<Topico> findByCursoAndDataCriacaoYear(String curso,int ano, Pageable pageable);
}