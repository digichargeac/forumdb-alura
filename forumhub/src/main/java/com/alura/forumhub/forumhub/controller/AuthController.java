package com.alura.forumhub.forumhub.controller;

import com.alura.forumhub.forumhub.domain.usuario.Usuario;
import com.alura.forumhub.forumhub.dto.DadosLogin;
import com.alura.forumhub.forumhub.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid DadosLogin dados){

        var authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        dados.login(),
                        dados.senha()
                );

        var authentication = manager.authenticate(authenticationToken);

        var token = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(token);
    }
}