package com.usman.hostelmanagementsystem.controller;

import com.usman.hostelmanagementsystem.dto.ResponseDto;
import com.usman.hostelmanagementsystem.dto.RoomDto;
import com.usman.hostelmanagementsystem.dto.StaffDto;
import com.usman.hostelmanagementsystem.dto.StudentDto;
import com.usman.hostelmanagementsystem.mapper.StaffMapper;
import com.usman.hostelmanagementsystem.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

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

    @PostMapping("/")
    public  ResponseEntity<ResponseDto> saveStafff(@RequestBody StaffDto dto){
        service. registerStaff(mapper.toEntity(dto));
        return ResponseEntity.ok(ResponseDto.builder().message("staff saved").build());
    }

    @PostMapping("/")
    public  ResponseEntity<ResponseDto> updateStafff(@RequestBody StaffDto dto, long id){
        service.  updateStaff(mapper.toEntity(dto),id);
        return ResponseEntity.ok(ResponseDto.builder().message("staff updated").build());
    }

    @GetMapping("/")
    public ResponseEntity<Page<StaffDto>> getRoomIfAvailable(Pageable pageable){
        return ResponseEntity.ok(new PageImpl<>(mapper.toDto(service. getAllStaff(pageable).getContent())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> saveHostel( @PathVariable long id){
        service. deleteStaff(id);
        return ResponseEntity.ok(ResponseDto.builder().message("staff deleted").build());
    }

    @GetMapping("/email/{email}/tc/{tc}")
    public ResponseEntity<StaffDto> getstaffByEmailORTc(@PathVariable String email, @PathVariable BigInteger tc){
        return ResponseEntity.ok(mapper.toDto(service. getByEmailOrTc(email,tc)));
    }

}
