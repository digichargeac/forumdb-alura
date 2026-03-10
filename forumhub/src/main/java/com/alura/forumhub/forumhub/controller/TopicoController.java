package com.alura.forumhub.forumhub.controller;

import com.alura.forumhub.forumhub.domain.topico.Topico;
import com.alura.forumhub.forumhub.domain.topico.TopicoRepository;
import com.alura.forumhub.forumhub.domain.topico.dto.DadosAtualizacaoTopico;
import com.alura.forumhub.forumhub.domain.topico.dto.DadosCadastroTopico;
import com.alura.forumhub.forumhub.domain.topico.dto.DadosDetalhamentoTopico;
import com.alura.forumhub.forumhub.domain.topico.dto.DadosListagemTopico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
public class TopicoController {

    private final TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados){

        if(repository.existsByTituloAndMensagem(dados.titulo(),dados.mensagem())){
            return ResponseEntity.badRequest().body("Topico duplicado");
        }

        var topico = new Topico(
                dados.titulo(),
                dados.mensagem(),
                dados.autor(),
                dados.curso()
        );

        repository.save(topico);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public Page<DadosListagemTopico> listar(
            @PageableDefault(size=10,sort="dataCriacao") Pageable paginacao
    ){

        return repository.findAll(paginacao)
                .map(DadosListagemTopico::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){

        var topico = repository.findById(id);

        if(topico.isPresent()){
            return ResponseEntity.ok(new DadosDetalhamentoTopico(topico.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(
            @PathVariable Long id,
            @RequestBody @Valid DadosAtualizacaoTopico dados){

        var optional = repository.findById(id);

        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var topico = optional.get();

        topico.atualizar(
                dados.titulo(),
                dados.mensagem(),
                dados.autor(),
                dados.curso()
        );

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){

        if(!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}