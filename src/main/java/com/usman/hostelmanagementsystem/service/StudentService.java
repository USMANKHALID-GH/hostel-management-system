package com.usman.hostelmanagementsystem.service;

import com.usman.hostelmanagementsystem.dto.RegisterDto;
import com.usman.hostelmanagementsystem.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    public  void  register(Student register);

    public Student  getStudentByEmailORTc(String email, Integer tc);

    public  Student findStudentById(long id);

    public  void updateStudent(Integer tc);

    public   void deleteStudent(long id);

    public  void deactivateStudent(long id);

    public Page<Student>  getAllStudent(Pageable pageable);


    public  void changeRoom(long StudentId,  long roomId, int bedNumber);



}
