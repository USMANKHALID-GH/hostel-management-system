package com.usman.hostelmanagementsystem.controller;

import com.usman.hostelmanagementsystem.dto.ResponseDto;
import com.usman.hostelmanagementsystem.mapper.StaffMapper;
import com.usman.hostelmanagementsystem.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService service;
    private final StaffMapper mapper;


    @PostMapping("/student/{studentId}/bed/{bedId}")
    public  ResponseEntity<ResponseDto> approveStudent(@PathVariable long studentId, @PathVariable long bedId){
        service.approveStudent(studentId, bedId);
        return ResponseEntity.ok(ResponseDto.builder().message("room saved").build());
    }
}
