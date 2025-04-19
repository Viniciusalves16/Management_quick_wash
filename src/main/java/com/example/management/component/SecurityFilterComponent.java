package com.example.management.component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//Filter que realiza a verificação de todas as requisições
//será executada apenas uma vez por requisição

@Component
public class SecurityFilterComponent extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = recoverToken(request);
        filterChain.doFilter(request, response);


    }

    // recupera o token que esta sendo enviado via header
    private String recoverToken(HttpServletRequest request) {

        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null) {
            throw new RuntimeException("token jwt not received");
        }
        return authorizationHeader.replace("Bearer" , "");
    }
}
