package com.usman.hostelmanagementsystem.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String country;
    private String city;
    private String  town;
    private String cityCode;
    private String streeetName;
    private String streetCode;
    private  String appartmentName;
    private  int apartmentNO;

}
