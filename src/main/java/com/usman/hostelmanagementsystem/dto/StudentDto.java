package com.usman.hostelmanagementsystem.dto;

import com.usman.hostelmanagementsystem.model.Address;
import com.usman.hostelmanagementsystem.model.Parent;
import com.usman.hostelmanagementsystem.model.Room;
import jakarta.persistence.Embedded;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.Date;

public class StudentDto extends BaseDto {
    private  Long id;
    private String firstName;
    private   String surname;
    private   Integer   tc;
    private Integer  studentNumber;
    private String country;
    private boolean isActive;
    private boolean isGuest;
    private String  image;
    private  Integer  telefon;
    private   String email;
    private boolean isDisabled;
    private  String department;
    private String course;
    private String  gender;
    private Date dateOfbBirth;
    private  int numberNumber;
    private Room room;
    private Address address;

}
