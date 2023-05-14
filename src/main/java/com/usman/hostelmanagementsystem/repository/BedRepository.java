package com.usman.hostelmanagementsystem.repository;

import com.usman.hostelmanagementsystem.model.Bed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long> {

    boolean existsBedByBedNumberAndAndRoom_Id(long bedNumber, long roomId);



    boolean existsBedsByOccupied(boolean occupiod);


}
