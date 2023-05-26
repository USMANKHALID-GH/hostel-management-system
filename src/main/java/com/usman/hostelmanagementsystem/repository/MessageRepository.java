package com.usman.hostelmanagementsystem.repository;

import com.usman.hostelmanagementsystem.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Messages, Long> {
}
