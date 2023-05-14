package com.usman.hostelmanagementsystem.repository;

import com.usman.hostelmanagementsystem.model.Parent;
import com.usman.hostelmanagementsystem.model.Room;
import com.usman.hostelmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByRoom(Room room);

    Optional<Student>  findStudentByParent(Parent parent);

    Optional<Student> findStudentByEmailOrTc(String email, String tc);
}
