package com.example.management.service;

import com.example.management.controller.RegisterController;
import com.example.management.dto.RequestRegisterDto;
import com.example.management.entities.register.Register;
import com.example.management.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class RegisterService {


    @Autowired
    RegisterRepository registerRepository;

    public ResponseEntity saveRegisterService(RequestRegisterDto registerDto) {

        var registerModelTemp = new Register(registerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerRepository.save(registerModelTemp));
    }


    public ResponseEntity<List<Register>> findAllService() {
        List<Register> registerModels = registerRepository.findAll();
        if (!registerModels.isEmpty()) {
            for (Register registerModel : registerModels) {
                UUID id = registerModel.getCustomerId();
                registerModel.add(linkTo(methodOn(RegisterController.class).getOneRegister(id)).withSelfRel());
            }
            return ResponseEntity.status(HttpStatus.OK).body(registerModels);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }


    public ResponseEntity<Object> getOneRegisterService(UUID id) {
      var registerModel = registerRepository.findById(id);
        if (registerModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register Not Found ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(registerModel.get());
    }

    public ResponseEntity<Object> updateRegisterService(UUID id, RequestRegisterDto request) {
        Optional<Register> registerModel = registerRepository.findById(id);

        if (registerModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register Not Found ");
        }
        Register updateRegister = new Register(request);
        updateRegister.setCustomerId(id);

        return ResponseEntity.status(HttpStatus.OK).body(updateRegister);
    }

    public ResponseEntity<Object> deleteRegisterService(UUID id) {
        Optional<Register> findRegisterId = registerRepository.findById(id);

        if (findRegisterId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("register not found");
        }
        registerRepository.delete(findRegisterId.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted Sucessfully");
    }

}
