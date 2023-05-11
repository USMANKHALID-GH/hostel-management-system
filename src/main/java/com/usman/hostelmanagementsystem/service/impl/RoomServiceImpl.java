package com.usman.hostelmanagementsystem.service.impl;

import com.usman.hostelmanagementsystem.model.Hostel;
import com.usman.hostelmanagementsystem.model.Room;
import com.usman.hostelmanagementsystem.repository.RoomRepository;
import com.usman.hostelmanagementsystem.service.HostelService;
import com.usman.hostelmanagementsystem.service.RoomService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@AllArgsConstructor

public class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;
    private  final HostelService hostelService;

    @Override
    public void saveRoom(@Valid Room room, long hostelId) {

        Hostel hostel=hostelService.findById(hostelId);
        room.setHostel(hostel);
        repository.save(room);


    }
}
