package com.usman.hostelmanagementsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String  town;
    private String cityCode;
    @Column(nullable = false)
    private String streeetName;
    private String streetCode;
    @Column(nullable = false)
    private  String appartmentName;
    private  int apartmentNO;

}
