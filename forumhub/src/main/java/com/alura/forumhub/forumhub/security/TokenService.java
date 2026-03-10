package com.alura.forumhub.forumhub.security;

import com.alura.forumhub.forumhub.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    public String gerarToken(Usuario usuario){

        try {

            Algorithm algoritmo = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("forum-api")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(
                            Instant.now().plusSeconds(86400)
                    )
                    .sign(algoritmo);

        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token");
        }

    }
    public String validarToken(String token){

        try {

            Algorithm algoritmo = Algorithm.HMAC256(secret);

            return JWT.require(algoritmo)
                    .withIssuer("forum-api")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException exception){
            return null;
        }
    }

}