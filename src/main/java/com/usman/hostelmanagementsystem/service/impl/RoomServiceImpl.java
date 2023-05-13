package com.usman.hostelmanagementsystem.service.impl;

import com.usman.hostelmanagementsystem.exception.BusinessException;
import com.usman.hostelmanagementsystem.model.Hostel;
import com.usman.hostelmanagementsystem.model.Room;
import com.usman.hostelmanagementsystem.repository.RoomRepository;
import com.usman.hostelmanagementsystem.service.HostelService;
import com.usman.hostelmanagementsystem.service.RoomService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private  final HostelService hostelService;

    @Override
    public void saveRoom(@Valid Room room, long hostelId) {

        Hostel hostel=hostelService.findById(hostelId);
        room.setHostel(hostel);
        roomRepository.save(room);


    }

    @Override
    public Room findById(long id) {
        return roomRepository.findById(id)
                .orElseThrow(()->new BusinessException(HttpStatus.NOT_FOUND,"ROOM ID IS NOT IN OUR SYSTEM "+id));
    }

    @Override
    public Page<Room> findRoomIfAvailable(Pageable pageable) {
        return roomRepository.findRoomIfReady(pageable);
    }

    @Override
    public void setRoomReady(long id) {
        Room room=findById(id);
        room.setReady(true);
        roomRepository.save(room);
    }

    @Override
    public Room findRoomByRoomNumber(String roomNumber) {
        return roomRepository.findRoomByRoomNumber(roomNumber)
                .orElseThrow(()->new BusinessException("ROOM NUMBER IS NOT IN OUR SYSTEM "+roomNumber));
    }
}
