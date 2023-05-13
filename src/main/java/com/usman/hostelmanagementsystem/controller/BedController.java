package com.usman.hostelmanagementsystem.controller;

import com.usman.hostelmanagementsystem.dto.BedDto;

import com.usman.hostelmanagementsystem.dto.ResponseDto;
import com.usman.hostelmanagementsystem.mapper.BedMapper;
import com.usman.hostelmanagementsystem.service.BedService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/bed")
public class BedController {

    private final BedService service;
    private final BedMapper mapper;

    @PostMapping("/room/{roomId}")
    public ResponseEntity<ResponseDto> saveHostel(@RequestBody BedDto dto, @PathVariable long roomId){
        service.saveBed(mapper.toEntity(dto), roomId);
        return ResponseEntity.ok(ResponseDto.builder().message("Hostel saved").build());
    }



}
