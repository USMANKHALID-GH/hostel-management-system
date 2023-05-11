package com.usman.hostelmanagementsystem.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;

import java.util.Date;

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
@Where(clause = "deleted = false")
@Table(name = "student")
public class Student extends AbstractModel {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String firstName;
    private   String surname;
    private   Integer   tc;
    private Integer  studentNumber;
    private boolean isActive;
    private boolean isGuest;
    private String  image;
    private  Integer  telefon;
    private   String email;
    private boolean isDisabled;
    private  String department;
    private String course;
    private String  gender;
    private Date   dateOfbBirth;
    private  int numberNumber;


    @ManyToOne
    private Room room;
    private  int bedNumber;
    @Embedded
    private Address  address;

    @ManyToOne
    @JoinColumn(nullable = true)
    private  Parent  parent;


}
