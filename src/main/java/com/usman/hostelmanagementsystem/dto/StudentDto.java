package com.usman.hostelmanagementsystem.dto;

import com.usman.hostelmanagementsystem.model.Address;

import com.usman.hostelmanagementsystem.model.Parent;
import com.usman.hostelmanagementsystem.model.Room;
import lombok.Data;



import java.util.Date;
@Data
public class StudentDto extends BaseDto {
    private  Long id;
    private String firstName;
    private   String surname;
    private   String   tc;
    private String  studentNumber;
    private String country;
    private boolean isActive;
    private boolean isGuest;
    private String  image;
    private  String  telefon;
    private   String email;
    private boolean isDisabled;
    private  String department;
    private String course;
    private String  gender;
    private Date dateOfBirth;
    private  int numberNumber;
    private Room room;
    private Address address;
    private Parent parent;
    private BedDto bed;

}
