package com.usman.hostelmanagementsystem.service;

import com.usman.hostelmanagementsystem.model.Room;
import jakarta.validation.Valid;

public interface RoomService {

    public void saveRoom(Room room , long hostelId);
}
