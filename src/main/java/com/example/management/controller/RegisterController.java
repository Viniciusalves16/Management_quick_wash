package com.example.management.controller;

import com.example.management.dto.RequestRegisterDto;
import com.example.management.models.RegisterModel;
import com.example.management.repository.RegisterRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegisterController {

    @Autowired
    RegisterRepository registeRepository;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<RegisterModel> saveRegister(@RequestBody @Valid RequestRegisterDto registerDto) {
        var registerModelTemp = new RegisterModel(registerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeRepository.save(registerModelTemp));
    }

    @GetMapping("")
    public ResponseEntity <List<RegisterModel> >findAllRegister() {
      return ResponseEntity.ok().body(registeRepository.findAll());
    }

}
