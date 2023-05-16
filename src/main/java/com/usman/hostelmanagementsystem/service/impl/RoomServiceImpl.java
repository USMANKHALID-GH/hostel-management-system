package com.usman.hostelmanagementsystem.service.impl;

import com.usman.hostelmanagementsystem.exception.BusinessException;
import com.usman.hostelmanagementsystem.model.Hostel;
import com.usman.hostelmanagementsystem.model.Room;
import com.usman.hostelmanagementsystem.repository.RoomRepository;
import com.usman.hostelmanagementsystem.repository.StudentRepository;
import com.usman.hostelmanagementsystem.service.HostelService;
import com.usman.hostelmanagementsystem.service.RoomService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@AllArgsConstructor

public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private  final HostelService hostelService;
    private  final StudentRepository studentRepository;

    @Override
    public void saveRoom(@Valid Room room, long hostelId) {

        Hostel hostel=hostelService.findById(hostelId);
        if(roomRepository.findRoomByRoomNumberAndHostel(room.getRoomNumber(),hostel).isPresent()){
            throw new BusinessException(HttpStatus.NOT_FOUND,"ROOM ALREADY EXIST");
        }
        if(ObjectUtils.isEmpty(room.getRoomType())){
            throw new BusinessException(HttpStatus.NOT_FOUND,"ROOM TYPE MUST BE PROVIDED ");
        }
        if(ObjectUtils.isEmpty(room.getRoomNumber())){
           throw  new BusinessException(HttpStatus.NOT_FOUND,"ROOM NUMBER MUST BE PROVIDED ");
        }

        room.setHostel(hostel);
        room.setRoomCapacity(0);
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
    public Room findRoomByRoomNumberAndHostel(String roomNumber,long hostelId) {
        Hostel hostel =hostelService.findById(hostelId);
        return roomRepository.findRoomByRoomNumberAndHostel(roomNumber,hostel)
                .orElseThrow(()->new BusinessException("ROOM NUMBER IS NOT IN OUR SYSTEM "+roomNumber));
    }

    @Override
    public void UpdateRoom( long id) {
       Room room= findById(id);
       if(studentRepository.existsByRoom(room)){
           new BusinessException(HttpStatus.FORBIDDEN,"CANT SET ROOM NOT READY BECAUSE IS OCCUPIED"+id);
       }
       room.setReady(false);
       roomRepository.save(room);



    }
}
