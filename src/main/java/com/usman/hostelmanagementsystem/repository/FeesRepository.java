package com.usman.hostelmanagementsystem.repository;

import com.usman.hostelmanagementsystem.model.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeesRepository extends JpaRepository<Fees,Long> {
}
