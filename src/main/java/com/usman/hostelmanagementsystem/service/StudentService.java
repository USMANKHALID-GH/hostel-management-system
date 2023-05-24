package com.usman.hostelmanagementsystem.service;


import com.usman.hostelmanagementsystem.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

      void  register(Student register);

     Student  getStudentByEmailORTc(String email, String tc);

      Student findStudentById(long id);

      void updateStudent(Student student,long id);

       void deleteStudent(long id);

      void deactivateStudent(long id);

    Page<Student>  getAllStudent(Pageable pageable);


      void changeRoom(long StudentId,  long roomId, long bedNumber);

    Student findStudentByParent(String email, String tc);

    void makeStudentQuest(long id);

    List<Student> findStudentWhoHaventPaid(Pageable pageable);



}
