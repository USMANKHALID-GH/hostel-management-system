package com.usman.hostelmanagementsystem.controller;

import com.usman.hostelmanagementsystem.dto.BedDto;
import com.usman.hostelmanagementsystem.model.Fees;
import com.usman.hostelmanagementsystem.model.Student;
import com.usman.hostelmanagementsystem.service.FeesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/student-fees")
public class FeesController {

    private  final FeesService service;

//    @GetMapping("/{id}")
//    public ResponseEntity<List<Student>> getBedById(){
//        return ResponseEntity.ok(service.getStudentFromFees());
//    }
}
