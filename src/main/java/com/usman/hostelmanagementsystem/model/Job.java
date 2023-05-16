package com.usman.hostelmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Data
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE job SET deleted=true WHERE id=?")
@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@Table(name = "job")
public class Job extends  AbstractModel{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String description;
    private Double salaryAmount;

    @ManyToMany
    @JoinTable(name = "job_staff", joinColumns = @JoinColumn(name = "job_id")
    ,inverseJoinColumns = @JoinColumn(name = "staff_id")
    )
    private List<Staff> staff;
}
