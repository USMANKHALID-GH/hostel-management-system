package com.usman.hostelmanagementsystem.service.impl;

import com.usman.hostelmanagementsystem.model.Hostel;
import com.usman.hostelmanagementsystem.repository.HostelRepository;
import com.usman.hostelmanagementsystem.service.HostelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class HostelServiceImpl  implements HostelService {

    private final HostelRepository hostelRepository;

    @Override
    public void saveHostel(@Valid  Hostel hostel) {
        hostelRepository.save(hostel);
    }

    @Override
    public Page<Hostel> getAllHostelBycity(String city, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Hostel> getAllHostel(Pageable pageable) {
        return hostelRepository.findAll(pageable);
    }

    @Override
    public Hostel findById(long id) {
        log.info(id+"///////////////////////////////////////////////////////////1");
       return  hostelRepository.findById(id)
               .orElseThrow(()->new RuntimeException("there is an error"));
    }
}
