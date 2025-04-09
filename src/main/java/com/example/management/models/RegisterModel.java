package com.example.management.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
@Data
@Entity
@Table(name= "TB_ CUSTOMER_REGISTER")
public class RegisterModel implements Serializable {

    private static  final  long serialVersionUID = 1l;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCustomer;
    private String name;
    private BigDecimal age;

    @Embedded
    private AddressModel addresModel;

}
