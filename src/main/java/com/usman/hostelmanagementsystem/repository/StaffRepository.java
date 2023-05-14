package com.usman.hostelmanagementsystem.repository;

import com.usman.hostelmanagementsystem.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    Optional<Staff> findStaffByEmailOrIdentityNumber(String email, BigInteger tc);
}
