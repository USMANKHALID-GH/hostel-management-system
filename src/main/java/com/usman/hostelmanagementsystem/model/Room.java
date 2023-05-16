package com.usman.hostelmanagementsystem.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Data
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE room SET deleted=true WHERE id=?")
@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@Table(name = "room")
public class Room extends AbstractModel{
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String roomNumber;
    @Column(nullable = false,length = 4)
    private  int  roomCapacity=0;
    private  boolean isReady;

    private  Integer floorNumber;

    private  String roomType;

    @ManyToOne
    private Hostel hostel;

    @OneToMany(mappedBy = "room")
    private List<Bed> bed;
}
