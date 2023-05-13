package com.usman.hostelmanagementsystem.model;

import jakarta.persistence.Embedded;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE location SET deleted=true WHERE id=?")
@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@Table(name = "location")
public class Location  extends AbstractModel{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    @Column(nullable = false)
    @Embedded
    private Address  address;
}
