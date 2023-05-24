package com.usman.hostelmanagementsystem.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;


import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE student SET deleted=true WHERE id=?")

@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@Table(name = "student")
public class Student extends AbstractModel {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private   String surname;
    @Column(nullable = false,length = 11,unique = true)
    private String  tc;
    @Column(nullable = false,unique = true)
    private String   studentNumber;
    private boolean isActive;
    private boolean isGuest;
    private String  image;
    @Column(nullable = false, unique = true)
    private  String   telefon;
    @Email
    @Column(nullable = false, unique = true)
    private   String email;
    private boolean isDisabled;
    private  String department;
    private String course;
    @Column(nullable = false)
    private String  gender;
    private LocalDate dateOfBirth;
    @Column(length = 11,unique = true, updatable = false)
    private String hostelId;


    @ManyToOne
    private Room room;
    private  int bedNumber;
    @Embedded
    private Address  address;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private  Parent  parent;

    @OneToOne
    private Bed bed;


}
