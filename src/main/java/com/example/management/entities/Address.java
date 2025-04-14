package com.example.management.entities;

import com.example.management.dto.AddressDto;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cep;
    private String rua;
    private String cidade;
    private String numero;

    public Address(AddressDto addressDto) {
        this.cep = addressDto.code();
        this.rua = addressDto.street();
        this.cidade = addressDto.city();
        this.numero = addressDto.number();
    }

    public Address() {
    }
}
