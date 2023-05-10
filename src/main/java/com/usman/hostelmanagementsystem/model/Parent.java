package com.usman.hostelmanagementsystem.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;


import java.util.Date;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

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
    private String firstName;
    private   String surname;
    private   Integer   identtyNumber;
    private boolean isActive;
    private String  image;
    private  Integer  telefon;
    private   String email;
    private String  gender;
    private Date dateOfbBirth;
}
