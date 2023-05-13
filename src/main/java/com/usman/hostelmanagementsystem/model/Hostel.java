package com.usman.hostelmanagementsystem.model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Data
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE blog SET deleted=true WHERE id=?")
@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "hostel")
public class Hostel  extends AbstractModel {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    @Column(nullable = false)
    private boolean isMixed;
    @Column(nullable = false, unique = true)
    @NotNull(message = "name cant be null")
    @NotEmpty(message = "name cant be empty")
    private String name;
    @Column(nullable = false)
    @NotNull(message = "gender cant be null")
    @NotEmpty(message = "gender cant be empty")
    private String gender;

    private String image;
    private String aboutHostel;

    @OneToOne(orphanRemoval = true,optional = false,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, unique = true)
    private Location location;

}
