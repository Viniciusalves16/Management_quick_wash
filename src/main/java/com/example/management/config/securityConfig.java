package com.example.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

// Classe de configuração de segurança
@Configuration
@EnableWebSecurity // indica que as configurações serão personalizadas
public class securityConfig {

    // filtra as requisições, csrf desabilitado devido na utilizarmos token que possui segurança
    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}
