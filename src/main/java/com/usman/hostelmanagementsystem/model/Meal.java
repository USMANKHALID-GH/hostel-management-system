package com.usman.hostelmanagementsystem.model;


import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Meal {

    private String breakFast[];

    private String lunch[];
    private String supper[];
}
