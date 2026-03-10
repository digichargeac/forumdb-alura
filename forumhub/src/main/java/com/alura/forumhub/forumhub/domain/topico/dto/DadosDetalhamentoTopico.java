package com.alura.forumhub.forumhub.domain.topico.dto;

import com.alura.forumhub.forumhub.domain.topico.StatusTopico;
import com.alura.forumhub.forumhub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(

        Long id,
        String titulo,
        String mensagem,
        String autor,
        String curso,
        LocalDateTime dataCriacao,
        StatusTopico status

) {

    public DadosDetalhamentoTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getDataCriacao(),
                topico.getStatus()
        );
    }
}