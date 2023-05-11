package com.usman.hostelmanagementsystem.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;


import java.util.Date;
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
@Where(clause = "deleted = false")
@Table(name = "paarent")
public class Parent extends AbstractModel {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private   String surname;
    @Column(nullable = false)
    private   Integer   identtyNumber;
    private boolean isActive;
    @Column(nullable = false)
    private String  image;
    @Column(nullable = false)
    private  Integer  telefon;
    @Column(nullable = false)
    private   String email;
    @Column(nullable = false)
    private String  gender;
    @Column(nullable = false)
    private Date dateOfbBirth;
}
