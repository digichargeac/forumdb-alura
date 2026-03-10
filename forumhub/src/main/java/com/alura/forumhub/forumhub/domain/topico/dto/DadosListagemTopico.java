package com.alura.forumhub.forumhub.domain.topico.dto;

import com.alura.forumhub.forumhub.domain.topico.Topico;

public record DadosListagemTopico(

        Long id,
        String titulo,
        String mensagem,
        String autor,
        String curso

) {
    public DadosListagemTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}