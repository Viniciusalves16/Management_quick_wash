package com.example.management.controller;

import com.example.management.dto.login.DataAutentication;
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

    @PostMapping
    @Transactional
    public ResponseEntity authenticateUser(@RequestBody @Valid DataAutentication dataAutentication) {


        // dessa forma é acionado de forma indireta a classe AuthenticationService que realiza a consulta do login no banco de dados
        var token = new UsernamePasswordAuthenticationToken(dataAutentication.login() , dataAutentication.password());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }

}
