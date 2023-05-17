package com.usman.hostelmanagementsystem.controller;

import com.usman.hostelmanagementsystem.dto.BedDto;


import com.usman.hostelmanagementsystem.dto.HostelDto;
import com.usman.hostelmanagementsystem.dto.ResponseDto;
import com.usman.hostelmanagementsystem.mapper.BedMapper;
import com.usman.hostelmanagementsystem.service.BedService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/bed")
public class BedController {

    @Autowired
    private final BedService service;
    @Autowired
    private final BedMapper mapper;

    @PostMapping("/room/{roomId}")
    public ResponseEntity<ResponseDto> saveBed(@RequestBody BedDto dto, @PathVariable long roomId){
        service.saveBed(mapper.toEntity(dto), roomId);
        return ResponseEntity.ok(ResponseDto.builder().message("Hostel saved").build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BedDto> getBedById(@PathVariable long id){
        return ResponseEntity.ok(mapper.toDto(service.findBedBYId(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteBed(@PathVariable long id){
         service.deleteUpdate(id);
        return ResponseEntity.ok(ResponseDto.builder().message("bed Updated ").build());
    }


    @GetMapping("/ready-bed")
    public ResponseEntity<Page<BedDto>> getAllReadyBed(Pageable pageable){
        return ResponseEntity.ok(new PageImpl<>(mapper.toDto(service.getAllAlreadyBed(pageable).getContent())));
    }

    @PutMapping("/not-ready/{id}")
    public ResponseEntity<ResponseDto> updateBedNotReady(@PathVariable long id){
        service.UpdateBedReady(id);
        return ResponseEntity.ok(ResponseDto.builder().message("bed Updated ").build());
    }





}
