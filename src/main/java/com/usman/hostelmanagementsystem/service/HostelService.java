package com.usman.hostelmanagementsystem.service;

import com.usman.hostelmanagementsystem.model.Hostel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HostelService {

    void saveHostel(Hostel hostel);

    Page<Hostel> getAllHostelBycity(String city, Pageable pageable);
    Page<Hostel> getAllHostel(Pageable pageable);

    Hostel findById(long id);

    Page<Hostel> getByGender(String gender,  Pageable pageable);

}
