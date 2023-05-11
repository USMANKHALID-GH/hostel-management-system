package com.usman.hostelmanagementsystem.dto;

import com.usman.hostelmanagementsystem.model.Address;

import lombok.Data;


import java.util.Date;
@Data
public class StaffDto extends BaseDto {
    private  Long id;
    private String firstName;
    private   String surname;
    private   Integer   identityNumber;
    private String country;
    private String  image;
    private  Integer  telefon;
    private   String email;
    private String  gender;
    private Date dateOfbBirth;
    private  String qualificaation;
    private Address address;
}
