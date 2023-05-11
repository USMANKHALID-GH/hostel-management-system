package com.usman.hostelmanagementsystem.controller;

import com.usman.hostelmanagementsystem.dto.HostelDto;
import com.usman.hostelmanagementsystem.dto.ResponseDto;
import com.usman.hostelmanagementsystem.mapper.HostelMapper;
import com.usman.hostelmanagementsystem.service.HostelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/hostel/")
public class HostelController {

    private  final HostelService service;
    private  final HostelMapper mapper;

    @PostMapping("/")
    public ResponseEntity<ResponseDto> saveHostel(@RequestBody HostelDto dto){
        service.saveHostel(mapper.toEntity(dto));
        return ResponseEntity.ok(ResponseDto.builder().message("Hostel saved").build());
    }
}
