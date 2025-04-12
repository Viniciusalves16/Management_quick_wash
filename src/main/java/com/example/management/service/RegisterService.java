package com.example.management.service;

import com.example.management.controller.RegisterController;
import com.example.management.dto.RequestRegisterDto;
import com.example.management.models.RegisterModel;
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

        var registerModelTemp = new RegisterModel(registerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerRepository.save(registerModelTemp));
    }


    public ResponseEntity<List<RegisterModel>> findAllService() {
        List<RegisterModel> registerModels = registerRepository.findAll();

        if (!registerModels.isEmpty()) {
            for (RegisterModel registerModel : registerModels) {
                UUID id = registerModel.getIdCustomer();
                registerModel.add(linkTo(methodOn(RegisterController.class).getOneRegister(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(registerModels);
    }


    public ResponseEntity<Object> getOneRegisterService(UUID id) {
        Optional<RegisterModel> registerModel = registerRepository.findById(id);
        if (registerModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register Not Found ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(registerModel.get());
    }

    public ResponseEntity<Object> updateRegisterService(UUID id, RequestRegisterDto request) {
        Optional<RegisterModel> registerModel = registerRepository.findById(id);

        if (registerModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register Not Found ");
        }
        RegisterModel updateRegister = new RegisterModel(request);
        updateRegister.setIdCustomer(id);

        return ResponseEntity.status(HttpStatus.OK).body(updateRegister);
    }

    public ResponseEntity<Object> deleteRegisterService( UUID id) {
        Optional<RegisterModel> findRegisterId = registerRepository.findById(id);

        if (findRegisterId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("register not found");
        }
        registerRepository.delete(findRegisterId.get());
        return  ResponseEntity.status(HttpStatus.OK).body("Register deleted Sucessfully");
    }

}
