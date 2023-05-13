package com.usman.hostelmanagementsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String  town;
    private String cityCode;
    @Column(nullable = false)
    private String streetName;
    private String streetCode;
    @Column(nullable = false)
    private  String apartmentName;
    private  int apartmentNo;

}
