package com.usman.hostelmanagementsystem.repository;

import com.usman.hostelmanagementsystem.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
