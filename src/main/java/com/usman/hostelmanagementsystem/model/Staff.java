package com.usman.hostelmanagementsystem.model;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE parent SET deleted=true WHERE id=?")
@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@Table(name = "staff")
public class Staff extends AbstractModel{
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Long id;
    @NotNull(message = "Staff first name cant be empty")
    @Column(nullable = false)
    private String firstName;
    @NotNull(message = "Staff second name cant be empty")
    @Column(nullable = false)
    private   String surname;
    @NotNull(message = "Staff Tc cant be empty")
    @Column(nullable = false)
    private BigInteger identityNumber;

    private boolean isActive=false;
    private String  image;
    @Column(nullable = false, unique = true)
    private  Integer  telefon;
    @Column(nullable = false, unique = true)
    private   String email;
    private boolean isDisabled;
    @Column(nullable = false)
    private String  gender;
    private Date dateOfbBirth;
    private  String qualificaation;


    @Embedded
    private Address  address;

    @ManyToOne
    private  Hostel hostel;


}
