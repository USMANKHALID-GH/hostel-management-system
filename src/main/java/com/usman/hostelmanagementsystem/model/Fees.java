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
import java.util.Date;

@Validated
@Data
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE fees SET deleted=true WHERE id=?")
@Entity
@DynamicInsert
@DynamicUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

@Table(name = "fees")
public class Fees  extends AbstractModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    private long studentId;
    private LocalDate monthAndYear;
    private Double amount;
}
