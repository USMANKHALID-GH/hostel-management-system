package com.usman.hostelmanagementsystem.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE room SET deleted=true WHERE id=?")
@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Where(clause = "deleted = false")
@Table(name = "roomm")
public class Room extends AbstractModel{
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String roomNumber;
    private  int  roomCapacity;
    private  boolean isReady;
    private  int numberOfBed;
    private  Integer floorNumber;


    private Hostel hostel;
}
