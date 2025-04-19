package com.example.management.controller;

import com.example.management.dto.login.DataAutentication;
import com.example.management.dto.login.TokenDataJWT;
import com.example.management.entities.login.User;
import com.example.management.service.TokenService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    public ResponseEntity authenticateUser(@RequestBody @Valid DataAutentication dataAutentication) {

        // dessa forma é acionado de forma indireta a classe AuthenticationService que realiza a consulta do login no banco de dados
        var authenticationToken = new UsernamePasswordAuthenticationToken(dataAutentication.login(), dataAutentication.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.CreateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenDataJWT(tokenJWT));
    }

}
