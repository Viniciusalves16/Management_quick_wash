package com.example.management.models;

import com.example.management.dto.AddressDto;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
public class AddressModel  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String cep;
    private String rua;
    private String cidade;
    private String numero;

    public AddressModel(AddressDto addressDto) {
        this.cep = addressDto.code();
        this.rua = addressDto.street();
        this.cidade = addressDto.city();
        this.numero = addressDto.number();
    }

    public AddressModel() {
    }
}
