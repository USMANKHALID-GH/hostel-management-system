package com.usman.hostelmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

@Validated
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@Table(name = "food")
public class Food  extends AbstractModel{
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Embedded
    private Meal  meals;

    @OneToOne
    private  Staff staffId;
}



