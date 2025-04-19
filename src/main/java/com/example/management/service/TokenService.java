package com.example.management.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.management.entities.login.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Locale;

@Service
public class TokenService {

    public String CreateToken(User user) {

        //.withClaim("id", user.getPassword()) // pode ser utilizar para trafegar outros tipos de atributos do usuário


        //Método que realiza a criação do token
        try {
            var algorithm = Algorithm.HMAC256("1234");
            return JWT.create()
                    .withIssuer("API Management Quick Wash")
                    .withSubject(user.getLogin())
                    .withExpiresAt(dateExpiration())
                    .sign(algorithm);

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro generate token ", exception);
        }
    }

    // Método responsável por implementar o tempo de expiração do token
    private Instant dateExpiration() {
        return LocalDateTime.now().plusMinutes(5).toInstant(ZoneOffset.of("-03:00"));
    }
}
