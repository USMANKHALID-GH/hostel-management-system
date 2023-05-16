package com.usman.hostelmanagementsystem.service;

import com.usman.hostelmanagementsystem.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface RoomService {

    void saveRoom(Room room , long hostelId);

    Room findById(long id);
    Page<Room>  findRoomIfAvailable(Pageable pageable);

    void setRoomReady(long id);

    Room findRoomByRoomNumberAndHostel(String roomNumber,long  hostelId);

    void UpdateRoom(long id);


}
