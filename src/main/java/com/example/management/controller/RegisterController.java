package com.example.management.controller;

import com.example.management.dto.RequestRegisterDto;
import com.example.management.entities.Register;
import com.example.management.service.RegisterService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<Register> saveRegister(@RequestBody @Valid RequestRegisterDto registerDto) {
        return registerService.saveRegisterService(registerDto);
    }

    @GetMapping("/register")
    public ResponseEntity<List<Register>> findAllRegister() {
        return registerService.findAllService();
    }


    @GetMapping("register/{id}")
    public ResponseEntity<Object> getOneRegister(@PathVariable(value = "id") UUID id) {
        return registerService.getOneRegisterService(id);
    }

    @PutMapping("register/{id}")
    public ResponseEntity<Object> updateRegister(@PathVariable(value = "id") UUID id,
                                                 @RequestBody @Valid RequestRegisterDto request) {
        return registerService.updateRegisterService(id, request);

    }

    @DeleteMapping("/register/{id}")
    public ResponseEntity<Object> deteleRegister(@PathVariable(value = "id") UUID id) {
        return registerService.deleteRegisterService(id);
    }

}