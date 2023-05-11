package com.usman.hostelmanagementsystem.service.impl;

import com.usman.hostelmanagementsystem.dto.RegisterDto;
import com.usman.hostelmanagementsystem.model.Student;
import com.usman.hostelmanagementsystem.repository.StudentRepository;
import com.usman.hostelmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public void register(@Valid Student register) {
      studentRepository.save(register);
    }

    @Override
    public Student getStudentByEmailORTc(String email, Integer tc) {
        return null;
    }

    @Override
    public Student findStudentById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException());
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
        return null;
    }

    @Override
    public void changeRoom(long StudentId, long roomId, int bedNumber) {

    }
}
