package com.example.management.controller;

import com.example.management.dto.RequestRegisterDto;
import com.example.management.models.RegisterModel;
import com.example.management.repository.RegisterRepository;
import jakarta.validation.Valid;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    RegisterRepository registeRepository;


    @PostMapping("/register")
    public ResponseEntity<RegisterModel> saveRegister(@RequestBody @Valid RequestRegisterDto registerDto) {

        var registerModel = new RegisterModel();
        BeanUtils.copyProperties(registerDto, registerModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeRepository.save(registerModel));
    }


}
