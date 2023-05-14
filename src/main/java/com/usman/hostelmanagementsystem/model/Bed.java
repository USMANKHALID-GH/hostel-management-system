package com.usman.hostelmanagementsystem.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;

@Data
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE bed SET deleted=true WHERE id=?")
@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@Table(name = "bed")
public class Bed extends AbstractModel{
    private static final long serialVersionUID = 1L;

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    @Column(nullable = false)
    private int bedNumber;
    private boolean isOccupied;
    private  boolean isReady;

    @ManyToOne
    private Room room;

}
