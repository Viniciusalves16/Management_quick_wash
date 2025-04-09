package com.example.management.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
@Embeddable
@Data
@Table(name = "TB_ADDRESS")
public class AddressModel {


    private String code;
    private String street;
    private String district;
    private String city;
    private String number;
    private String complement;
}
