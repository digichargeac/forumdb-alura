package com.alura.forumhub.forumhub.domain.topico;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    private String autor;

    private String curso;

    public Topico(String titulo,String mensagem,String autor,String curso){
        this.titulo=titulo;
        this.mensagem=mensagem;
        this.autor=autor;
        this.curso=curso;
        this.status=StatusTopico.ABERTO;
        this.dataCriacao=LocalDateTime.now();
    }

    public void atualizar(String titulo,String mensagem,String autor,String curso){
        this.titulo=titulo;
        this.mensagem=mensagem;
        this.autor=autor;
        this.curso=curso;
    }
}