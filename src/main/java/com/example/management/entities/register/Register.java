package com.example.management.entities.register;

import com.example.management.dto.RequestRegisterDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "customers")
@AllArgsConstructor
public class Register extends RepresentationModel<Register> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long customerId;
    private String nome;
    private int idade;

    @Embedded
    private Address addressModel;

    public Register(RequestRegisterDto registerDto) {
        this.nome = registerDto.name();
        this.idade = registerDto.age();
        this.addressModel = new Address(registerDto.addressDto());
    }

    public Register() {
    }

    public Register(Long idCustomer) {
        this.customerId = idCustomer;
    }

}
