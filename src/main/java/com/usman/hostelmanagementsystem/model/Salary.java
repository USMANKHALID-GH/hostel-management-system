package com.usman.hostelmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Set;

@Validated
@Data
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE salary SET deleted=true WHERE id=?")
@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@Table(name = "salary")
public class Salary extends  AbstractModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    private  double  amount;

    private LocalDate monthAndYear;

    @ManyToMany
    private Set<Job> job;

    @ManyToOne
    private  Staff staff;
}
