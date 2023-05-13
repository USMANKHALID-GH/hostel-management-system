package com.usman.hostelmanagementsystem.controller;

import com.usman.hostelmanagementsystem.dto.ResponseDto;
import com.usman.hostelmanagementsystem.dto.RoomDto;
import com.usman.hostelmanagementsystem.dto.StudentDto;
import com.usman.hostelmanagementsystem.mapper.StudentMapper;
import com.usman.hostelmanagementsystem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService service;
    private final StudentMapper mapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> saveHostel(@RequestBody StudentDto dto){
        service.register(mapper.toEntity(dto));
        return ResponseEntity.ok(ResponseDto.builder().message("room saved").build());
    }
    @GetMapping("/")
    public ResponseEntity<Page<StudentDto>> getRoomIfAvailable(Pageable pageable){
        return ResponseEntity.ok(new PageImpl<>(mapper.toDto(service.getAllStudent(pageable).getContent())));
    }


}
