package com.usman.hostelmanagementsystem.service;


import com.usman.hostelmanagementsystem.model.Bed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BedService {

    void saveBed(Bed bed, long roomId);

    Bed findBedBYId(long id);

    void UpdateBedReady(long id);

    void deleteUpdate(long id);

    Page<Bed> getAllAlreadyBed(Pageable pageable);

}
