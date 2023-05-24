package com.usman.hostelmanagementsystem.repository;

import com.usman.hostelmanagementsystem.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
