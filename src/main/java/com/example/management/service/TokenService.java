package com.example.management.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.management.entities.login.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.quick_wash.security.token.secret}")
    private String secret;

    public String CreateToken(User user) {

        //.withClaim("id", user.getPassword()) // pode ser utilizar para trafegar outros tipos de atributos do usuário
        //Método que realiza a criação do token
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Management Quick Wash")
                    .withSubject(user.getLogin())
                    .withExpiresAt(dateExpiration())
                    .sign(algorithm);

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro generate token ", exception);
        }
    }


    //validação do token que esta sendo recebido na requisição
    public String getSubject(String tokenJWT) {

        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("API Management Quick Wash")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception) {
         throw new RuntimeException("Token JWT Invalid or Expired");
        }
    }


    // Método responsável por implementar o tempo de expiração do token
    private Instant dateExpiration() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
