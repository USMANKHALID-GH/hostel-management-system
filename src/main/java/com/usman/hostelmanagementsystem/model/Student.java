package com.usman.hostelmanagementsystem.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

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
    private Date   dateOfbBirth;
    private  int numberNumber;
    @ManyToOne
    private Room room;
    @Embedded
    private Address  address;

    @OneToOne
    private  Parent  parent;

}
