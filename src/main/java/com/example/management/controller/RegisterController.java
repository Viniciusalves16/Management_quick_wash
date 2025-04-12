package com.example.management.controller;

import com.example.management.dto.RequestRegisterDto;
import com.example.management.models.RegisterModel;
import com.example.management.repository.RegisterRepository;
import com.example.management.service.RegisterService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.tomcat.Jar;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<RegisterModel> saveRegister(@RequestBody @Valid RequestRegisterDto registerDto) {
        return registerService.saveRegisterService(registerDto);
    }

    @GetMapping("/register")
    public ResponseEntity<List<RegisterModel>> findAllRegister() {
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