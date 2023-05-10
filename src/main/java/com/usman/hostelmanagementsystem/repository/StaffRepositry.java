package com.usman.hostelmanagementsystem.repository;

import com.usman.hostelmanagementsystem.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepositry extends JpaRepository<Staff, Long> {
}
