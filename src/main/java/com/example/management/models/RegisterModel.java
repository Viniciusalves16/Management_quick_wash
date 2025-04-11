package com.example.management.models;

import com.example.management.dto.RequestRegisterDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.service.annotation.GetExchange;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "customers")
@AllArgsConstructor
public class RegisterModel  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCustomer;
    private String nome;
    private int idade;

    @Embedded
    private AddressModel addressModel;

    public RegisterModel(RequestRegisterDto registerDto) {
        this.nome = registerDto.name();
        this.idade = registerDto.age();
        this.addressModel = new AddressModel(registerDto.addressDto());
    }

    public RegisterModel() {
    }
}
