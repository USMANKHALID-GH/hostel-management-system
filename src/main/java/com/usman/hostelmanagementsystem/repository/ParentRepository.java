package com.usman.hostelmanagementsystem.repository;

import com.usman.hostelmanagementsystem.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

    Optional<Parent> findParentByEmailOrIdentityNumber(String email, String tc);
}
