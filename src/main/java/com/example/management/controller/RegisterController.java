package com.example.management.controller;

import com.example.management.dto.RequestRegisterDto;
import com.example.management.models.RegisterModel;
import com.example.management.repository.RegisterRepository;
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
    RegisterRepository registeRepository;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<RegisterModel> saveRegister(@RequestBody @Valid RequestRegisterDto registerDto) {
        var registerModelTemp = new RegisterModel(registerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeRepository.save(registerModelTemp));
    }

    @GetMapping("/register")
    public ResponseEntity<List<RegisterModel>> findAllRegister() {
        List<RegisterModel> registerModels = registeRepository.findAll();

        if (!registerModels.isEmpty()) {
            for (RegisterModel registerModel : registerModels) {
                UUID id = registerModel.getIdCustomer();
                registerModel.add(linkTo(methodOn(RegisterController.class).getOneRegister(id)).withSelfRel());
            }
        }
       return ResponseEntity.status(HttpStatus.OK).body(registerModels);
    }

    @GetMapping("register/{id}")
    public ResponseEntity<Object> getOneRegister(@PathVariable(value = "id") UUID id) {
        Optional<RegisterModel> registerModel = registeRepository.findById(id);

        if (registerModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register Not Found ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(registerModel.get());
    }

    @PutMapping("register/{id}")
    public ResponseEntity<Object> updateRegister(@PathVariable(value = "id") UUID id,
                                                 @RequestBody @Valid RequestRegisterDto request) {

        Optional<RegisterModel> registerModel = registeRepository.findById(id);

        if (registerModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register Not Found ");
        }
        RegisterModel updateRegister = new RegisterModel(request);
        updateRegister.setIdCustomer(id);

        return ResponseEntity.status(HttpStatus.OK).body(registeRepository.save(updateRegister));

    }

    @DeleteMapping("/register/{id}")
    public ResponseEntity<Object> deteleRegister(@PathVariable(value = "id") UUID id) {
        Optional<RegisterModel> findRegisterId = registeRepository.findById(id);

        if (findRegisterId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("register not found");
        }
        registeRepository.delete(findRegisterId.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted Sucessfully");
    }
}