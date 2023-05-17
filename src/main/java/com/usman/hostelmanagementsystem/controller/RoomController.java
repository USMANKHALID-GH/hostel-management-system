package com.usman.hostelmanagementsystem.controller;


import com.usman.hostelmanagementsystem.dto.ResponseDto;
import com.usman.hostelmanagementsystem.dto.RoomDto;
import com.usman.hostelmanagementsystem.mapper.RoomMapper;
import com.usman.hostelmanagementsystem.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    private final RoomService service;
    @Autowired
    private final RoomMapper mapper;

    @PostMapping("/hostel/{hostelId}")
    public ResponseEntity<ResponseDto> saveRoom(@RequestBody RoomDto dto, @PathVariable long hostelId){
        service.saveRoom(mapper.toEntity(dto),hostelId);
        return ResponseEntity.ok(ResponseDto.builder().message("room saved").build());
    }

    @GetMapping("/ready/")
    public ResponseEntity<Page<RoomDto>> getRoomIfAvailable( Pageable pageable){
        return ResponseEntity.ok(new PageImpl<>(mapper.toDto(service.findRoomIfAvailable(pageable).getContent())));
    }

    @PostMapping("/make-room-read/{id}")
    public ResponseEntity<ResponseDto> makeRoomReady(@PathVariable("id") long id){
        service.setRoomReady(id);
        return ResponseEntity.ok(ResponseDto.builder().message("Room saved").build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable long id){
        return ResponseEntity.ok(mapper.toDto(service.findById(id)));
    }

    @GetMapping("/room-number/{roomNumber}/hostel/{hostelId}")
    public ResponseEntity<RoomDto> getRoomByNumber(@PathVariable String roomNumber,@PathVariable long hostelId){
        return ResponseEntity.ok(mapper.toDto(service.findRoomByRoomNumberAndHostel(roomNumber ,hostelId)));
    }

    @PutMapping("/make-room-not-ready/{id}")
    public ResponseEntity<ResponseDto> updateRoom(@PathVariable("id") long id){
        service.UpdateRoom(id);
        return ResponseEntity.ok(ResponseDto.builder().message("Room updated").build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteRoom( @PathVariable long id){
        service.deleteRoom(id);
        return ResponseEntity.ok(ResponseDto.builder().message("room deleted").build());
    }
}
