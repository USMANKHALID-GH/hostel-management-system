package com.usman.hostelmanagementsystem.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE blog SET deleted=true WHERE id=?")
@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Where(clause = "deleted = false")
@Table(name = "hostel")
public class Hostel  extends AbstractModel {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    @Column(nullable = false)
    private boolean isMixed;
    @Column(nullable = false)
    private String name;

    private String image;
    private String aboutHostel;

    @Column(nullable = false)
    @OneToOne
    private Location location;

}
