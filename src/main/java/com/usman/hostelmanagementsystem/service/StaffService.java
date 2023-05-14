package com.usman.hostelmanagementsystem.service;

import com.usman.hostelmanagementsystem.dto.StaffDto;
import com.usman.hostelmanagementsystem.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;

public interface StaffService {

    public  void registerStaff(Staff staff);

    public  void approveStudent(long studnetId,long bedId);


    public  void updateStaff(Staff staff,long id);

   Page<Staff> getAllStaff(Pageable pageable);

    public  void deleteStaff(long id);

    public void changePosition(long id);

    public  Staff getByEmailOrTc(String email, BigInteger tc);

    Staff getStaffById(long id);


}
