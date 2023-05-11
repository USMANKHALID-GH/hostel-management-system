package com.usman.hostelmanagementsystem.service.impl;


import com.usman.hostelmanagementsystem.model.Staff;
import com.usman.hostelmanagementsystem.model.Student;
import com.usman.hostelmanagementsystem.repository.StaffRepository;
import com.usman.hostelmanagementsystem.service.StaffService;
import com.usman.hostelmanagementsystem.service.StudentService;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StaffServiceImpl  implements StaffService {

    private final StaffRepository staffRepository;

    private  final StudentService studentService;

    @Override
    public void registerStaff(Staff staff) {
           staffRepository.save(staff);
    }

    @Override
    public void approveStudent(long studnetId) {
        Student student= studentService.findStudentById(studnetId);
        student.setActive(true);


    }

    @Override
    public void updateStaff(long id) {

    }

    @Override
    public Page<Staff> getAllStaff() {
        return null;
    }

    @Override
    public void deleteStaff(long id) {

    }

    @Override
    public void changePosition(long id) {

    }

    @Override
    public Staff getByEmailOrTc(String email, Integer tc) {
        return null;
    }
}
