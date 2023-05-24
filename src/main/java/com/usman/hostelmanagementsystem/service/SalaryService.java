package com.usman.hostelmanagementsystem.service;


import com.usman.hostelmanagementsystem.model.Salary;

public interface  SalaryService {
    void saveSalary(Salary salary, long jobId);
}
