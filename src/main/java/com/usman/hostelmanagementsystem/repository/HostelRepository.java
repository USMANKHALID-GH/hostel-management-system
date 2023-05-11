package com.usman.hostelmanagementsystem.repository;

import com.usman.hostelmanagementsystem.model.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostelRepository  extends JpaRepository<Hostel, Long> {
}
