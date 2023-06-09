package com.usman.hostelmanagementsystem.dto;

import lombok.Data;

@Data
public class RoomDto extends BaseDto {
    private Long Id;
    private String roomNumber;
    private  int  roomCapacity;
    private  boolean isReady;
    private  Integer floorNumber;
    private  String roomType;
}
