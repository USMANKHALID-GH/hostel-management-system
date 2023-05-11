package com.usman.hostelmanagementsystem.service;

import com.usman.hostelmanagementsystem.dto.StaffDto;
import com.usman.hostelmanagementsystem.model.Staff;
import org.springframework.data.domain.Page;

public interface StaffService {

    public  void registerStaff(Staff staff);

    public  void approveStudent(long studnetId);


    public  void updateStaff(long id);

    public Page<Staff> getAllStaff();

    public  void deleteStaff(long id);

    public void changePosition(long id);

    public  Staff getByEmailOrTc(String email, Integer tc);


}
