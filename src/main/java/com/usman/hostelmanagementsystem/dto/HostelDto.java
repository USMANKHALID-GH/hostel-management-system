package com.usman.hostelmanagementsystem.dto;

import com.usman.hostelmanagementsystem.model.Location;

import lombok.Data;

@Data
public class HostelDto extends BaseDto{
    private boolean isMixed;
    private String name;
    private String gender;
    private String image;
    private String aboutHostel;
    private Location location;

}
