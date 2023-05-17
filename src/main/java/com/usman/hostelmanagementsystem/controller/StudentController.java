package com.usman.hostelmanagementsystem.controller;


import com.usman.hostelmanagementsystem.dto.ResponseDto;

import com.usman.hostelmanagementsystem.dto.StudentDto;
import com.usman.hostelmanagementsystem.mapper.StudentMapper;
import com.usman.hostelmanagementsystem.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private final StudentService service;
    @Autowired
    private final StudentMapper mapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody StudentDto dto ){
//        log.info("/////////");
//        String s= StringUtils.cleanPath(file.getOriginalFilename());
//        log.info(file.getName()+" "+file.getContentType()+" "+file.getOriginalFilename());
//        dto.setImage(s);
        service.register(mapper.toEntity(dto));
        return ResponseEntity.ok(ResponseDto.builder().message("room saved").build());
    }


    @GetMapping("/")
    public ResponseEntity<Page<StudentDto>> getAllStudent(Pageable pageable){
        return ResponseEntity.ok(new PageImpl<>(mapper.toDto(service.getAllStudent(pageable).getContent())));
    }

    @GetMapping("/parent-email/{email}/parent-tc/{tc}")
    public ResponseEntity<StudentDto>findStudentByParent(@PathVariable String email, @PathVariable String tc){
        return ResponseEntity.ok(mapper.toDto(service.findStudentByParent(email,tc)));
    }

    @GetMapping("/email/{email}/tc/{tc}")
    public ResponseEntity<StudentDto> getStudentByEmailORTc(@PathVariable String email, @PathVariable String tc){
        return ResponseEntity.ok(mapper.toDto(service.getStudentByEmailORTc(email,tc)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getRoomIfAvailable(@PathVariable long id){
        return ResponseEntity.ok(mapper.toDto(service.findStudentById(id)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteStudent( @PathVariable long id){
        service. deleteStudent(id);
        return ResponseEntity.ok(ResponseDto.builder().message("Student deleted").build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateStudent(@RequestBody StudentDto dto, @PathVariable long id){
        service.updateStudent(mapper.toEntity(dto), id);
        return ResponseEntity.ok(ResponseDto.builder().message("updated saved").build());
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<ResponseDto> deactivateStudent( @PathVariable long id){
        service.deactivateStudent(id);
        return ResponseEntity.ok(ResponseDto.builder().message("Student deactivated").build());
    }

    @PutMapping("/make-guest/{id}")
    public ResponseEntity<ResponseDto> makeStudentQuest( @PathVariable long id){
        service.makeStudentQuest(id);
        return ResponseEntity.ok(ResponseDto.builder().message("Guest made successfully").build());
    }

    @PutMapping("/room/{roomId}/bed-number/{bedId}")
    public ResponseEntity<ResponseDto>changeRoom( @PathVariable long roomId,  @PathVariable long bedId, @RequestParam("studentId")long studentId){
        service.changeRoom(studentId,roomId,bedId);
        return ResponseEntity.ok(ResponseDto.builder().message("room change successfully").build());
    }



}