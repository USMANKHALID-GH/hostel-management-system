package com.usman.hostelmanagementsystem.service.impl;

import com.usman.hostelmanagementsystem.dto.RegisterDto;
import com.usman.hostelmanagementsystem.exception.BusinessException;
import com.usman.hostelmanagementsystem.model.Student;
import com.usman.hostelmanagementsystem.repository.StudentRepository;
import com.usman.hostelmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Slf4j
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public void register(@Valid Student register) {
        LocalDate now = LocalDate.now();
        Period  period = Period.between(register.getDateOfBirth(),now);

        if(period.getYears()<16){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "YOU MUST BE ABOVE 16  TO REGISTER: "+period.getYears());
        }

        if(ObjectUtils.isEmpty(register.getFirstName())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "FIRST NAME MUST BE PROVIVED");
        }
        if(ObjectUtils.isEmpty(register.getSurname())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "SURNAME NAME MUST BE PROVIVED");
        }
        if(ObjectUtils.isEmpty(register.getTc())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "TC MUST BE PROVIVED");
        }
        if(ObjectUtils.isEmpty(register.getStudentNumber())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "Student NAME MUST BE PROVIVED");
        }
        if(ObjectUtils.isEmpty(register.getTelefon())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "TELEFON MUST BE PROVIVED");
        }
        if(ObjectUtils.isEmpty(register.getGender())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "GENDER MUST BE PROVIVED");
        }
        if(ObjectUtils.isEmpty(register.getDepartment())){
            throw  new BusinessException(HttpStatus.FORBIDDEN, "FIRST NAME MUST BE PROVIVED");
        }


      studentRepository.save(register);
    }

    @Override
    public Student getStudentByEmailORTc(String email, Integer tc) {
        return null;
    }

    @Override
    public Student findStudentById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(()->new BusinessException(HttpStatus.NOT_FOUND,"STUDENT ID IS NOT IN OUR SYSTEM "+id));
    }

    @Override
    public void updateStudent(Integer tc) {

    }

    @Override
    public void deleteStudent(long id) {

    }

    @Override
    public void deactivateStudent(long id) {

    }

    @Override
    public Page<Student> getAllStudent(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public void changeRoom(long StudentId, long roomId, int bedNumber) {

    }
}
