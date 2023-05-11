package com.usman.hostelmanagementsystem.controller;


import com.usman.hostelmanagementsystem.dto.ResponseDto;
import com.usman.hostelmanagementsystem.dto.RoomDto;
import com.usman.hostelmanagementsystem.mapper.RoomMapper;
import com.usman.hostelmanagementsystem.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/room")
public class RoomController {
    private final RoomService service;
    private final RoomMapper mapper;
    @PostMapping("/hostel/{hostelId}")
    public ResponseEntity<ResponseDto> saveHostel(@RequestBody RoomDto dto, @PathVariable long hostelId){
        service.saveRoom(mapper.toEntity(dto),hostelId);
        return ResponseEntity.ok(ResponseDto.builder().message("room saved").build());
    }

}
